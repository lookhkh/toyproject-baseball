package com.baseball.main;

import java.util.Scanner;

import com.baseball.user.session.manager.CLIUserSessionManager;
import com.baseball.user.session.manager.UserSessionManager;
import com.baseball.user.session.manager.ui.CLIUserInterface;
import com.baseball.user.session.manager.ui.UserInterface;
import com.baseball.user.session.proxy.UserProxy;

public class EntryPoint {
  
	public static void main(String[] args) {
		
		UserInterface ui = new CLIUserInterface(new Scanner(System.in));
		
		UserSessionManager manager = new CLIUserSessionManager(ui);
		
		manager.showMenu();
		
		String userId = manager.registerUserId();
		
		UserProxy userProxy = manager.selectGameMode();
		
	}
}
