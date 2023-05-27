package com.baseball.user.session.proxy.actionStrategy.factory;

import com.baseball.user.session.proxy.actionStrategy.UserActionStrategy;
import com.baseball.user.session.proxy.actionStrategy.consts.UserActionStrategeConsts;
import com.baseball.user.session.proxy.actionStrategy.enums.ActionEnum;
import com.baseball.user.session.proxy.actionStrategy.imple.GetCurrentUserInfoStrategy;

public class UserActionStrategyFactory {

	

	public static UserActionStrategy getUserActionStrategy(ActionEnum type, Object obj) {
		
		if(type.getType().equals(UserActionStrategeConsts.REQ_USER_INFO)) {
			return new GetCurrentUserInfoStrategy(obj);
		}
		
		throw new IllegalStateException("Not implemented");
	}
}
