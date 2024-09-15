package br.com.testLucelia.passwordValidate.component;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import br.com.testLucelia.passwordValidate.component.impl.PasswordValidateComponentRulesImpl;

@TestInstance(value = Lifecycle.PER_CLASS)
class PasswordValidateComponentTest {
	
	static PasswordValidateComponent passwordComponent = new PasswordValidateComponentRulesImpl();
	
	@BeforeAll
	void init(){
	}
	
	@Test
	void testIsValidPasswordEmpty() {
		Assertions.assertEquals(false , passwordComponent.isValidPassword("  "));
	}
	
	@Test
	void testIsValidPassword() {
		String pwd =  "Senha#1234";
		Assertions.assertEquals(true , passwordComponent.isValidPassword(pwd));
	}
	
	@Test
	void testIsValidPasswordCharacterReapete() {
		String pwd =  "Senha#12344";
		Assertions.assertEquals(false , passwordComponent.isValidPassword(pwd));
	}

	@Test
	void testIsInValidPasswordWhiteSpace() {
		String pwd =  "Senha 12344";
		Assertions.assertEquals(false , passwordComponent.isValidPassword(pwd));
	}
	
	@Test
	void testIsInValidPasswordCharacterSpecial() {
		String pwd =  "Senha}1234";
		Assertions.assertEquals(false , passwordComponent.isValidPassword(pwd));
	}
	
	@Test
	void testIsInValidPasswordLessCharacter() {
		String pwd =  "Senha}12";
		Assertions.assertEquals(false , passwordComponent.isValidPassword(pwd));
	}
}
