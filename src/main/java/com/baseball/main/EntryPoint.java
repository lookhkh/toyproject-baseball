package com.baseball.main;

import java.util.Scanner;

import com.baseball.user.session.manager.CLIUserSessionManager;
import com.baseball.user.session.manager.UserSessionManager;
import com.baseball.user.session.manager.ui.CLIUserInterface;
import com.baseball.user.session.manager.ui.UserInterface;
import com.baseball.user.session.proxy.UserProxy;
import com.baseball.user.session.proxy.actionStrategy.UserActionStrategy;

public class EntryPoint {
  
	public static void main(String[] args) {
		
		UserInterface ui = new CLIUserInterface(new Scanner(System.in));
		
		UserSessionManager manager = new CLIUserSessionManager(ui);
		
		manager.showMenu();
		
		manager.registerUserId();
		
		UserProxy userProxy = manager.selectGameMode();
		
		if(userProxy == null) return;
		
		System.out.println("게임 시작");
		
		while(true) {
			
			UserActionStrategy action = userProxy.prompt();
			action.work();
		}
	}
}
