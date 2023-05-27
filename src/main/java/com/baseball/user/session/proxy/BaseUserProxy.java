package com.baseball.user.session.proxy;

import java.time.LocalDateTime;

import com.baseball.rule.engine.GameEngine;

public abstract class BaseUserProxy implements UserProxy {

	private final String userId;
	private final LocalDateTime lastLoginTime;
	
	private final GameEngine engine;
	
	public BaseUserProxy(String userId,GameEngine engine) {
		this.userId = userId;
		this.engine = engine;
		this.lastLoginTime = LocalDateTime.now();
	}


	public String getUserId() {
		return userId;
	}
	
	public LocalDateTime getLastLoginTime() {
		return lastLoginTime;
	}
	
}
