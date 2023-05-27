package com.baseball.user.session.manager;

import com.baseball.user.session.manager.ui.UserInterface;
import com.baseball.user.session.proxy.UserProxy;

public class CLIUserSessionManager implements UserSessionManager {

	private final UserInterface ui;
	
	public CLIUserSessionManager(UserInterface ui) {
		this.ui = ui;
	}

	@Override
	public void showMenu() {
				
		ui.sendMessage(createWelcomeMessage());
		
	}
	
	@Override
	public String registerUserId() {

		String id =  registerUser();
		createIdSelectCompleteMsg(id);
		return id;
	}



	@Override
	public UserProxy selectGameMode() {
		
		ui.sendMessage(createProptSelectGameMode());
		
		String mode = ui.getUserInput();
	
		if(mode.equals("-1")) {
			ui.sendMessage("게임을 종료합니다.");
		}else if(!mode.equals("1")) {
			ui.sendMessage("지원하지 않는 모드입니다.");
			this.selectGameMode();
		}else if(mode.equals("1")) {
			ui.sendMessage("singleMode를 선택하였습니다.");
		}
		
		return null;
	}

	private String createProptSelectGameMode() {
		return "게임 모드를 선택해주세요.\n "+
				"1. SignleMode\n "+
				"-1 : exit";
	}

	private String createIdSelectCompleteMsg(String userId) {
		return userId+"를 사용합니다";
	}
	
	private String registerUser() {
		ui.sendMessage("ID를 입력해주세요.");
		return ui.getUserInput();
		
	}
	
	private String createWelcomeMessage() {
		StringBuilder b= new StringBuilder();
		b.append("--------------------------\n");
		b.append("-------Hello World--------\n");
		b.append("--------------------------\n");
		return b.toString();
	}




	
}
