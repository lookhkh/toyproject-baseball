package com.baseball.rule.engine.enums;

public enum FactoryType {

	DEFAULT_FACTORY("1");
	
	private String type;
	
	private FactoryType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}
	
	
	
}
