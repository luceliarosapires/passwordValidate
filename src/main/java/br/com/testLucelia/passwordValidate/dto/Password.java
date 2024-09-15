package br.com.testLucelia.passwordValidate.dto;

import java.io.Serializable;

public class Password implements Serializable {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	public Password() {
		super();
	}

	public String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
