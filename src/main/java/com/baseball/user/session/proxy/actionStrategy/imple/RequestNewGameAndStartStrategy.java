package com.baseball.user.session.proxy.actionStrategy.imple;

import com.baseball.rule.engine.GameEngine;
import com.baseball.rule.engine.consts.GameEngineConsts;
import com.baseball.rule.engine.vo.GuessResultVO;
import com.baseball.user.session.manager.ui.UserInterface;
import com.baseball.user.session.proxy.actionStrategy.UserActionStrategy;

import net.bytebuddy.build.Plugin.Engine;

public class RequestNewGameAndStartStrategy implements UserActionStrategy {

	private final GameEngine engine;
	private final UserInterface ui;
	
	public RequestNewGameAndStartStrategy(GameEngine engine,UserInterface ui) {
		this.engine = engine;
		this.ui = ui;
	}

	@Override
	public void work() {
		
		int gameStatus = 0;

		String gameId = engine.createNewGame();
		
		ui.sendMessage("새로운 게임을 시작합니다.");
		
		while(gameStatus != -1) {
			
			String nextUserGuess = ui.getUserInput();
			
			if(doesClientGiveUp(nextUserGuess)) {
				GuessResultVO curStatus = engine.getCurrentStatus(gameId);
				ui.sendMessage("game을 포기하였습니다. "+GuessResultVO);
				return;
			}
			
			GuessResultVO result =  engine.guessNextOne(gameId, nextUserGuess);
			
			if(result.isDone()) {
				ui.sendMessage("경기에서 승리 "+nextUserGuess);
				gameStatus = -1;
			}else {
				ui.sendMessage(createGameStatusMessage(result));
			}
			
		}
		

	}

	private boolean doesClientGiveUp(String nextUserGuess) {
		return nextUserGuess.equals(GameEngineConsts.USER_GIVE_UP);
	}

	private String createGameStatusMessage(GuessResultVO result) {

		return "경기 결과";
	}

	
}
