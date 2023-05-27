package com.baseball.rule.engine.vo;

public class GuessResultVO {
	
	private final String gid;
	private final String randomNumber;
	private int strikes;
	private int ball;
	private int cnt;
	public GuessResultVO(String gid, String randomNumber) {

		this.gid = gid;
		this.randomNumber = randomNumber;
		this.strikes = 0;
		this.ball = 0;
		this.cnt = 0;
	}
	
	public String getGid() {
		return gid;
	}
	public String getRandomNumber() {
		return randomNumber;
	}

	public int getStrikes() {
		return strikes;
	}

	public int getCount() {
		return cnt;
	}

	public int getBall() {
		return ball;
	}



	public boolean isDone() {
		return this.strikes == 3;
	}

	public void compute(String nextUserGuess) {
		int strike = 0;
		int ball = 0;
		
		cnt++;
		
		for(int i=0; i<3; i++) {
			char nextOne = nextUserGuess.charAt(i);
			for(int j=0; j<3; j++) {
				char n = this.randomNumber.charAt(j);
				if(nextOne == n) {
					if(i == j) strike ++;
					else ball++;
				}
			}
		}
		
		this.strikes= strike;
		this.ball = ball;
		
	}


	@Override
	public String toString() {
		return "GuessResultVO [gid=" + gid + ", randomNumber=" + randomNumber + ", strikes=" + strikes + ", ball="
				+ ball + ", cnt=" + cnt + "]";
	}

	
	
}
