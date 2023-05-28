# toyproject-baseball
﻿
새로운 토이프로젝트를 시작하였다. 비즈니스 요구사항을 간략히 하고자 기존에 존재하는 숫자야구 프로그램을 자바로 개발하는 것이다. 특히 객체지향 설계 및 디자인 패턴을 연습 및 적용하고자 UI 보다는 전체적인 설계 및 구조의 견고함에 더 주안점을 두었다.


해당 프로젝트의 요구사항은 다음과 같다.


숫자야구 게임을 진행한다.

  3자리의 숫자를 설정한다.

    싱글 모드라면 랜덤의 숫자를 설정한다.

    멀티모드라면 상대가 숫자를 수동으로 설정하거나 혹은 자동으로 설정할 수 있어야 한다.

      3자리 숫자는 0~9 사이의 자연수로 이루어져 있으며, 중복되지 않아야 한다.

      숫자와 자리가 동일하면 1 스트라이크이며, 3 스트라이크면 게임을 승리한다.

      숫자는 동일하나 자릿수가 다르면 1 볼이다.

      어떤 숫자도 동일하지 않다면 아웃이다.

    싱글, 멀티(PvP) 모드를 지원한다.

    게임에서 승리 시 래더 점수를 획득한다.

    본인의 정보를 확인할 수 있다.

    플레이어의 전체 랭킹을 확인할 수 있다.

    게임에서 패배하거나 중간에 포기하게 되면 래더 점수가 삭감된다. 중간에 포기할 경우 패널티를 부여한다

    소켓 기반의 실시간에 가까운 반응성을 제공한다.

    플레이어가 중간에 게임을 임의로 종료할 시, 시스템은 이를 감지할 수 있어야 한다.


  위의 요구사항을 충족하면서 견고한 어플리케이션 구조 구축 및, 수정과 변경에 쉽게 적응할 수 있는 구조를 구축하기 위하여 다음과 같은 클래스 구조를 설계하였다.

![image](https://github.com/lookhkh/toyproject-baseball/assets/62491156/88ed634d-5ce9-46bc-b2da-cf0e5c2746a4)

  디자인 주안점
  
  1. 사용자의 다양한 액션 ( 게임의 모드 선택, 사용자 정보 검색, 랭킹 검색 등 )을 확장가능하게 개발하기 위하여 전략패턴을 사용하였다. 유저의 입력값에 따라 팩토리 메소드에서 유저의 입력값에   상응하는 전략이 선택 및 실행된다.
  2. 멀티모드, 싱글모드에 따른 변경 요소에 대응하기 위하여 코드 내에서 각각의 객체는 interface로만 메시지를 주고 받을 수 있도록 하였다.
 
 ```
 public class UserActionStrategyFactory {


	public static UserActionStrategy getUserActionStrategy(ActionEnum type, Object obj) {
		
		if(type.getType().equals(UserActionStrategeConsts.EXIT)) {
			if(obj instanceof UserProxy) return new ExitGameStrategy((UserProxy)obj );
			return new ExitGameStrategy((UserProxy)obj);
		}
		
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

 ```


Release Note


v 0.1 싱글모드 게임 추가



Road Map


멀티 모드 기능 추가 - 서버 컴포넌트 개발 및 소켓 통신을 바탕으로 멀티 모드 지원 추가 예정

﻿
