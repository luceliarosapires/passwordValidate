package br.com.testLucelia.passwordValidate.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PasswordTest {

	@Test
    public void isPasswordTest() {
        Password pwd = new Password();
        pwd.setPassword("password");
        assertEquals("password", pwd.getPassword());
    }

}
