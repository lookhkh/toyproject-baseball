package com.baseball.user.session.manager.ui;

import java.util.Scanner;

public class CLIUserInterface implements UserInterface {

	private final Scanner in;

	public CLIUserInterface(Scanner in) {
		this.in = in;
	}
	@Override
	public String getUserInput() {
		return in.next();
	}

	@Override
	public void sendMessage(String msg) {
		System.out.println();
		System.out.println(msg);
		System.out.println();
	}
}
