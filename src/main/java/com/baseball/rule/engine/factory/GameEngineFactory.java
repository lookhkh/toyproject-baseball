package com.baseball.rule.engine.factory;

import java.util.NoSuchElementException;

import com.baseball.rule.engine.GameEngine;
import com.baseball.rule.engine.SimpleGameEngine;
import com.baseball.rule.engine.enums.FactoryType;

public class GameEngineFactory {

	public static GameEngine getGameEngineFactory(FactoryType type) {
		
		if(type.getType().equals("1")) return new SimpleGameEngine();
		
		throw new NoSuchElementException(type.name()+" doesn`t exist");
	}
}
