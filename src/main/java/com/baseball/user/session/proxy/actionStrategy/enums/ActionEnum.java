package com.baseball.user.session.proxy.actionStrategy.enums;

import java.util.NoSuchElementException;

import com.baseball.user.session.proxy.actionStrategy.consts.UserActionStrategeConsts;

public enum ActionEnum {

	REQUEST_NEW_GAME(UserActionStrategeConsts.REQUEST_NEW_GAME),  MY_INFO(UserActionStrategeConsts.REQ_USER_INFO), GET_RANKINGS(UserActionStrategeConsts.GET_RANKINGS);
	
	private String type;
	
	
	private ActionEnum(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public static ActionEnum getEnum(String type) {
		if(type.equals(UserActionStrategeConsts.REQUEST_NEW_GAME)) return ActionEnum.REQUEST_NEW_GAME;
		if(type.equals(UserActionStrategeConsts.REQ_USER_INFO)) return ActionEnum.MY_INFO;
		if(type.equals(UserActionStrategeConsts.GET_RANKINGS)) return ActionEnum.GET_RANKINGS;
		throw new NoSuchElementException(type+" dosen`t exist");
	}
}
