package com.baseball.user.session.proxy;

import java.util.List;

import com.baseball.user.session.dto.UserInfoDTO;
import com.baseball.user.session.proxy.actionStrategy.UserActionStrategy;

public interface UserProxy {

	public UserInfoDTO getMyInfo(String id);
	public List<UserInfoDTO> getUserRanking(int limit);
	public UserActionStrategy prompt();
	public void sendMessage(String message);
	public String getUserInput();
	public String getUserId();
	
}
