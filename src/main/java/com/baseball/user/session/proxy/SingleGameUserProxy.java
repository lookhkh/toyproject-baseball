package com.baseball.user.session.proxy;

import java.util.List;

import com.baseball.rule.engine.GameEngine;
import com.baseball.rule.engine.vo.GuessResultVO;
import com.baseball.user.session.dto.UserInfoDTO;
import com.baseball.user.session.manager.ui.UserInterface;
import com.baseball.user.session.proxy.actionStrategy.UserActionStrategy;
import com.baseball.user.session.proxy.actionStrategy.consts.UserActionStrategeConsts;
import com.baseball.user.session.proxy.actionStrategy.enums.ActionEnum;
import com.baseball.user.session.proxy.actionStrategy.factory.UserActionStrategyFactory;

public class SingleGameUserProxy extends BaseUserProxy {
	
	public SingleGameUserProxy(String userId, UserInterface ui) {
		super(userId,ui);
	}

	@Override
	public UserInfoDTO getMyInfo(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserInfoDTO> getUserRanking(int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserActionStrategy prompt() {
		
		this.sendUserMsg(createPromptNextMessage());
		String nextAction = this.getUserInput();

		if(nextAction.equals(UserActionStrategeConsts.REQ_USER_INFO)) {
			return UserActionStrategyFactory.getUserActionStrategy(ActionEnum.getEnum(nextAction), new UserInfoDTO());
		}
		
		if(nextAction.equals(UserActionStrategeConsts.REQUEST_NEW_GAME)) {
			return UserActionStrategyFactory.getUserActionStrategy(ActionEnum.REQUEST_NEW_GAME, this);
		}
		
		if(nextAction.equals(UserActionStrategeConsts.EXIT)) {
			return UserActionStrategyFactory.getUserActionStrategy(ActionEnum.EXIT, this);
		}
		
		throw new IllegalStateException("not implemented");

	}

	private String createPromptNextMessage() {
		return "what is your next Action?\n\n"+
			   "1 . REQUEST_NEW_GAME\n"+
			   "2 . REQ_USER_INFO\n"+
			   "-1 . Exit Game";
	}

	@Override
	public void sendMessage(String message) {
		this.sendUserMsg(message);
	}
	
	
}
