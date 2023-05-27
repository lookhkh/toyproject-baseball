package com.baseball.user.session.proxy;

import java.time.LocalDateTime;

import com.baseball.user.session.manager.ui.UserInterface;

public abstract class BaseUserProxy implements UserProxy {

	private final String userId;
	private final LocalDateTime lastLoginTime;
	private final UserInterface ui;
	
	public BaseUserProxy(String userId, UserInterface ui) {
		this.userId = userId;
		this.lastLoginTime = LocalDateTime.now();
		this.ui = ui;
	}


	public String getUserId() {
		return userId;
	}
	
	public LocalDateTime getLastLoginTime() {
		return lastLoginTime;
	}
	
	public void sendUserMsg(String msg) {
		this.ui.sendMessage(msg);
	}
	
	public String getUserInput() {
		return this.ui.getUserInput();
	}
	
}
