package com.baseball.rule.engine;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import com.baseball.rule.engine.sessions.GameSessionManager;
import com.baseball.rule.engine.vo.GuessResultVO;

public class SimpleGameEngine implements GameEngine {

	private final GameSessionManager manager;
	private final Random rand;;

	public SimpleGameEngine(GameSessionManager manager) {
		this.manager = manager;
		this.rand = new Random();
	}

	@Override
	public String createNewGame() {
		
		String gid = UUID.randomUUID().toString();
		String randomNumber = createRandomNumber(gid);
		
		GuessResultVO cur = new GuessResultVO(gid,randomNumber);
		
		manager.manage(cur);
		
		return gid;
	}

	private String createRandomNumber(String gid) {
		
		Set<String> rans = new HashSet<>();
		
		while(rans.size()<3) {
			
			String n = String.valueOf( rand.nextInt(1, 9) );
			rans.add(n);
		}
		
		return rans.stream()
				   .reduce("",(t1,t2)->t1+t2);
		
	}

	@Override
	public GuessResultVO guessNextOne(String gameId, String nextUserGuess) {
		
		GuessResultVO prevOne =  manager.findById(gameId);
		
		prevOne.compute(nextUserGuess);
		
		return prevOne;
	}

	@Override
	public GuessResultVO getCurrentStatus(String gameId) {
		return manager.findById(gameId);
	}

}
