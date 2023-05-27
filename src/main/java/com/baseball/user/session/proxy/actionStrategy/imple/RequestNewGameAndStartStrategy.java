package com.baseball.user.session.proxy.actionStrategy.imple;

import com.baseball.rule.engine.GameEngine;
import com.baseball.rule.engine.consts.GameEngineConsts;
import com.baseball.rule.engine.vo.GuessResultVO;
import com.baseball.user.session.proxy.UserProxy;
import com.baseball.user.session.proxy.actionStrategy.UserActionStrategy;

public class RequestNewGameAndStartStrategy implements UserActionStrategy {

	private final GameEngine engine;
	private final UserProxy proxy;
	
	public RequestNewGameAndStartStrategy(GameEngine engine,UserProxy proxy) {
		this.engine = engine;
		this.proxy = proxy;
	}

	@Override
	public void work() {
		
		int gameStatus = 0;

		String gameId = engine.createNewGame();
		
		proxy.sendMessage(GameEngineConsts.ANNOUNCE_NEW_GAME_MSG);
		
		GuessResultVO cur = this.engine.getCurrentStatus(gameId);
		
		while(gameStatus != -1) {
			
			proxy.sendMessage(createNextPrompteMessage(cur));
			String nextUserGuess = proxy.getUserInput();
			
			if(doesClientGiveUp(nextUserGuess)) {
				GuessResultVO curStatus = engine.getCurrentStatus(gameId);
				proxy.sendMessage(createGiveUpMessage(curStatus));
				return;
			}
			
			GuessResultVO result =  engine.guessNextOne(gameId, nextUserGuess);
			
			if(result.isDone()) {
				proxy.sendMessage(createGameWinMessage(nextUserGuess));
				gameStatus = -1;
			}else {
				proxy.sendMessage(createGameStatusMessage(result));
			}
		}
	}

	private String createNextPrompteMessage(GuessResultVO cur) {
		return "What is your next Guess?"+ 
				createCurrentGameStatus(cur);
	}

	private String createGameWinMessage(String nextUserGuess) {
		return "경기에서 승리 "+nextUserGuess;
	}

	private String createGiveUpMessage(GuessResultVO curStatus) {
		return "game을 포기하였습니다. "+curStatus;
	}

	private boolean doesClientGiveUp(String nextUserGuess) {
		return nextUserGuess.equals(GameEngineConsts.USER_GIVE_UP);
	}

	private String createGameStatusMessage(GuessResultVO result) {

		return "경기 결과 \n"+
				createCurrentGameStatus(result);
	}
	
	private String createCurrentGameStatus(GuessResultVO result) {
		return "strike : "+result.getStrikes()+"\n"+
				"ball : "+result.getBall()+"\n"+
				"cnt : "+result.getCount();
	}

	
}
