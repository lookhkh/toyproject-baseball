package com.baseball.user.session.proxy.actionStrategy.enums;

import java.util.NoSuchElementException;

import com.baseball.user.session.proxy.actionStrategy.consts.UserActionStrategeConsts;

public enum ActionEnum {

	REQUEST_NEW_GAME("1"), NEXT_GUESS("2"), MY_INFO(UserActionStrategeConsts.REQ_USER_INFO), GET_RANKINGS("4");
	
	private String type;
	
	
	private ActionEnum(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public static ActionEnum getEnum(String type) {
		if(type.equals("1")) return ActionEnum.REQUEST_NEW_GAME;
		if(type.equals("2")) return ActionEnum.NEXT_GUESS;
		if(type.equals(UserActionStrategeConsts.REQ_USER_INFO)) return ActionEnum.MY_INFO;
		if(type.equals("4")) return ActionEnum.GET_RANKINGS;
		throw new NoSuchElementException(type+" dosen`t exist");
	}
}
