package com.baseball.user.session.manager;

import com.baseball.user.session.proxy.UserProxy;

public interface UserSessionManager {
	
	public void showMenu();
	
	public UserProxy selectGameMode();
	public String registerUserId();
}
