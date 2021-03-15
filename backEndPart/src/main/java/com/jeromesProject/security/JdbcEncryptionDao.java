package com.jeromesProject.security;


import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcEncryptionDao implements EncryptionDao {
	
	private JdbcTemplate template;
	private int randomInt = (int)Math.random() * (27 - 0 + 1) + 0;
	private int usersRandomNum;
	
	public JdbcEncryptionDao(JdbcTemplate template) {
		this.template = template;
	}
	
	
	public Encryption getUserName(String username, String password) {
		String sql = "";
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	private String encrypt(String yourPw, int randomShiftNum) {
		if (randomShiftNum > 26) {
			randomShiftNum = randomShiftNum % 26;
		} else if (randomShiftNum < 0) {
			randomShiftNum = (randomShiftNum % 26) + 26;
		}
		
		char firstChar = yourPw.charAt(0);
		char lastChar = yourPw.charAt(-1);
		String addedSalt = new StringBuilder().append(lastChar).append(firstChar).toString();

		String encrypted = "";
		int lenghtOfPw = yourPw.length();

		for (int i = 0; i < lenghtOfPw; i++) {
			char ch = yourPw.charAt(i);
			if (Character.isLetter(ch)) {
				if (Character.isLowerCase(ch)) {
					char c = (char) (ch + randomShiftNum);
					if (c > 'z') {
						encrypted += (char) (ch - (26 - randomShiftNum));
					} else {
						encrypted += c;
					}
				} else if (Character.isUpperCase(ch)) {
					char c = (char) (ch + randomShiftNum);
					if (c > 'Z') {
						encrypted += (char) (ch - (26 - randomShiftNum));
					} else {
						encrypted += c;
					}
				}
			} else {
				encrypted += ch;
			}
		}
		return encrypted + addedSalt;
	}
	
	private String decrypt(String encryptedPw, int randomShiftNum) {
		if (randomShiftNum > 26) {
			randomShiftNum = randomShiftNum % 26;
		} else if (randomShiftNum < 0) {
			randomShiftNum = (randomShiftNum % 26) + 26;
		}
		

		String decrypted = "";
		int lenghtOfPw = encryptedPw.length();

		for (int i = 0; i < lenghtOfPw; i++) {
			char ch = encryptedPw.charAt(i);
			if (Character.isLetter(ch)) {
				if (Character.isLowerCase(ch)) {
					char c = (char) (ch - randomShiftNum);
					if (c < 'a') {
						decrypted += (char) (ch + (26 - randomShiftNum));
					} else {
						decrypted += c;
					}
				} else if (Character.isUpperCase(ch)) {
					char c = (char) (ch - randomShiftNum);
					if (c < 'A') {
						decrypted += (char) (ch + (26 - randomShiftNum));
					} else {
						decrypted += c;
					}
				}
			} else {
				decrypted += ch;
			}
		}
		return decrypted.substring(0, decrypted.length() - 2);
	}

	public String encrypt(Encryption encrypt) {
		return null;
	}







}
