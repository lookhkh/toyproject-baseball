package com.baseball.rule.engine.sessions;

import com.baseball.rule.engine.vo.GuessResultVO;

public interface GameSessionManager {

	public void manage(GuessResultVO cur);

	public GuessResultVO findById(String gameId);

	public void removeGame(String gameId);

}
