package com.baseball.user.session.proxy;

import java.time.LocalDateTime;

public abstract class BaseUserProxy implements UserProxy {

	private final String userId;
	private final LocalDateTime lastLoginTime;
	
	public BaseUserProxy(String userId) {
		this.userId = userId;
		this.lastLoginTime = LocalDateTime.now();
	}


	public String getUserId() {
		return userId;
	}
	
	public LocalDateTime getLastLoginTime() {
		return lastLoginTime;
	}
}
