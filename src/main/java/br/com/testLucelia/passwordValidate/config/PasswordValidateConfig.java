package br.com.testLucelia.passwordValidate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.testLucelia.passwordValidate.component.PasswordValidateComponent;
import br.com.testLucelia.passwordValidate.component.impl.PasswordValidateComponentRulesImpl;

@Configuration
public class PasswordValidateConfig {

	@Bean
	public PasswordValidateComponent getPasswordValidateComponent() {
		return new PasswordValidateComponentRulesImpl();
	}
}
