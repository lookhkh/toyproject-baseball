package com.baseball.rule.engine.sessions;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import com.baseball.rule.engine.vo.GuessResultVO;

public class InMemoryGameSessionManager implements GameSessionManager {
	
	private final Map<String, GuessResultVO> map;

	public InMemoryGameSessionManager() {
		this.map = new HashMap<>();
	}

	@Override
	public void manage(GuessResultVO cur) {
		this.map.put(cur.getGid(), cur);
	}

	@Override
	public GuessResultVO findById(String gameId) {
		if(this.map.containsKey(gameId)) return this.map.get(gameId);
		throw new NoSuchElementException(gameId+" doesn`t exist");
		
	}

	@Override
	public void removeGame(String gameId) {
		if(this.map.containsKey(gameId)) this.map.remove(gameId);
		throw new NoSuchElementException(gameId+" doesn`t exist");
		
	}

	
}
