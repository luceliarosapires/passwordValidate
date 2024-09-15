package br.com.testLucelia.passwordValidate.config;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

@TestInstance(value = Lifecycle.PER_CLASS)
class PasswordValidateConfigTest {
	
	@MockBean
	PasswordValidateConfig config;

	@BeforeAll
	void init(){
		config = Mockito.mock(PasswordValidateConfig.class);
	}
	
	@Test
	void test() {
		config.equals(new PasswordValidateConfig());
	}

}