package com.baseball.user.session.proxy.actionStrategy.imple;

import com.baseball.user.session.proxy.UserProxy;
import com.baseball.user.session.proxy.actionStrategy.UserActionStrategy;

public class ExitGameStrategy implements UserActionStrategy {
	
	private final UserProxy proxy;
	
	public ExitGameStrategy(UserProxy proxy) {
		this.proxy = proxy;
	}

	@Override
	public void work() {
		proxy.sendMessage("Really Want to Exit?");
		
		String answer = proxy.getUserInput();
		
		if(answer.contains("y") || answer.contains("Y")) {
			proxy.sendMessage("Bye "+proxy.getUserId());
			System.exit(0);
		}
	}

	
}
