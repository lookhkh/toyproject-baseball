package com.baseball.user.session.proxy.actionStrategy.factory;

import com.baseball.rule.engine.enums.FactoryType;
import com.baseball.rule.engine.factory.GameEngineFactory;
import com.baseball.user.session.proxy.UserProxy;
import com.baseball.user.session.proxy.actionStrategy.UserActionStrategy;
import com.baseball.user.session.proxy.actionStrategy.consts.UserActionStrategeConsts;
import com.baseball.user.session.proxy.actionStrategy.enums.ActionEnum;
import com.baseball.user.session.proxy.actionStrategy.imple.GetCurrentUserInfoStrategy;
import com.baseball.user.session.proxy.actionStrategy.imple.RequestNewGameAndStartStrategy;

public class UserActionStrategyFactory {


	public static UserActionStrategy getUserActionStrategy(ActionEnum type, Object obj) {
		
		if(type.getType().equals(UserActionStrategeConsts.REQ_USER_INFO)) {
			return new GetCurrentUserInfoStrategy(obj);
		}
		
		if(type.getType().equals(UserActionStrategeConsts.REQUEST_NEW_GAME)) {
			if(obj instanceof UserProxy) return new RequestNewGameAndStartStrategy(GameEngineFactory.getGameEngineFactory(FactoryType.DEFAULT_FACTORY), (UserProxy)obj );
			else new IllegalArgumentException("UserProxy 객체가 아닙니다.");
		}
		
		throw new IllegalStateException("Not implemented");
	}
}
