package com.baseball.rule.engine;

import com.baseball.rule.engine.vo.GuessResultVO;

public interface GameEngine {

	public String createNewGame();

	public GuessResultVO guessNextOne(String gameId, String nextUserGuess);

	public GuessResultVO getCurrentStatus(String gameId);

	public void finishCurrentGame(String gameId);

}
