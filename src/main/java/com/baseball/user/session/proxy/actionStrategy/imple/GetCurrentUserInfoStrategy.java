package com.baseball.user.session.proxy.actionStrategy.imple;

import com.baseball.user.session.dto.UserInfoDTO;
import com.baseball.user.session.proxy.actionStrategy.UserActionStrategy;

public class GetCurrentUserInfoStrategy implements UserActionStrategy {

	private final UserInfoDTO user;


	public GetCurrentUserInfoStrategy(Object obj) {
		if(!(obj instanceof UserInfoDTO)) throw new IllegalArgumentException("잘못된 타입의 인자가 생성자로 들어왔습니다.");
		this.user = (UserInfoDTO)obj;
	}

	@Override
	public void work() {
		System.out.println("my information is "+user);
	}
	
	
	
	
}
