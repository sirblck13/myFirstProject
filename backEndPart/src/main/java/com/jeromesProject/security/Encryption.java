package com.jeromesProject.security;

public class Encryption {
	
	private String password;
	private int randomNum;

	public Encryption(String password, int randomNum) {
		this.password = password;
		this.randomNum = randomNum;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRandomNum() {
		return randomNum;
	}
	public void setRandomNum(int randomNum) {
		this.randomNum = randomNum;
	}

}
