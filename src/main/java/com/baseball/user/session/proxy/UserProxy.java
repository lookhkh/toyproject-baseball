package com.baseball.user.session.proxy;

import java.util.List;

import com.baseball.rule.engine.vo.GuessResultVO;
import com.baseball.user.session.dto.UserInfoDTO;
import com.baseball.user.session.proxy.actionStrategy.UserActionStrategy;

public interface UserProxy {

	public String requestNewGame(String id);
	public GuessResultVO guessNextOne(String guess);
	public UserInfoDTO getMyInfo(String id);
	public List<UserInfoDTO> getUserRanking(int limit);
	public UserActionStrategy prompt();
	public void sendMessage(String message);
	public String getUserInput();
	
}
