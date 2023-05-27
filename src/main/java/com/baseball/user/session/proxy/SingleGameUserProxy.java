package com.baseball.user.session.proxy;

import java.util.List;

import com.baseball.rule.engine.GameEngine;
import com.baseball.rule.engine.vo.GuessResultVO;
import com.baseball.user.session.dto.UserInfoDTO;

public class SingleGameUserProxy extends BaseUserProxy {
	
	public SingleGameUserProxy(String userId, GameEngine engine) {
		super(userId, engine);
	}

	@Override
	public String requestNewGame(String id) {
		
		return null;
	}

	@Override
	public GuessResultVO guessNextOne(String guess) {
		// TODO Auto-generated method stub
		return null;
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

	
}
