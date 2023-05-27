package com.baseball.rule.engine.factory;

import java.util.NoSuchElementException;

import com.baseball.rule.engine.GameEngine;
import com.baseball.rule.engine.SimpleGameEngine;
import com.baseball.rule.engine.enums.FactoryType;
import com.baseball.rule.engine.sessions.GameSessionManager;
import com.baseball.rule.engine.sessions.InMemoryGameSessionManager;
import com.baseball.user.session.proxy.actionStrategy.enums.ActionEnum;

public class GameEngineFactory {

	public static GameEngine getGameEngineFactory(FactoryType type) {
		
		//TODO SessionManager 동적 할당 기능 추가하기
		GameSessionManager manager = new InMemoryGameSessionManager();
		
		if(type.getType().equals("1")) return new SimpleGameEngine(manager);
		
		throw new NoSuchElementException(type.name()+" doesn`t exist");
	}
}
