package br.com.testLucelia.passwordValidate.component.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import br.com.testLucelia.passwordValidate.component.PasswordValidateComponent;

@Component
public class PasswordValidateComponentRulesImpl implements PasswordValidateComponent {

	@Override
	public boolean isValidPassword(String password) {

		// Inicializa variáveis para verificar os requisitos
		boolean hasDigitValid = false;
		boolean hasDigitLowercase = false;
		boolean hasDigitUppercase = false;
		boolean hasDigitSpecial = false;
		boolean ret = false;
		
		Set<Character> charsUnique = new HashSet<>();
		
		// Verifica se a senha tem 9 ou mais caracteres
		if (password == null || password.isEmpty()|| password.length() < 9) {
			return false;
		}

		// Percorre cada caractere da senha
		for (char c : password.toCharArray()) {
			
			if (hasDigit(c)) {
				hasDigitValid = true;
			}	
			
			if (hasLowerCase(c)) {
				hasDigitLowercase = true;
			}
			
			if (hasUpperCase(c)) {
				hasDigitUppercase = true;
			}
			
			if (hasWhiteSpace(c)) {
				return ret;
			}
			
			if (hasCharValidSpecials(c)) {
				hasDigitSpecial = true;
			} 
			
			if (hasCharacterUnique(charsUnique, c)) {
				return ret;
			}
		}

		if (hasDigitValid && hasDigitLowercase && hasDigitUppercase && hasDigitSpecial) {
			ret = true;
		}

		return ret;
	}
	
	/**
	 * Verifica se o caracter é um digito
	 * @param Character
	 * @return boolean
	 */
	private boolean hasDigit(Character c) {
		return Character.isDigit(c);
	}
	
	/**
	 * Verificar se o caracter é uma letra minuscula
	 * @param Character
	 * @return boolean
	 */
	private boolean hasLowerCase(Character c) { 
		return Character.isLowerCase(c);
	} 
	
	/**
	 * Verifica se o caracter é uma letra maiuscula
	 * @param Character
	 * @return boolean
	 */
	private boolean hasUpperCase(Character c) {
		return Character.isUpperCase(c);
	}
	
	/**
	 * Verifica se o caracter é um espaço em branco
	 * @param Character
	 * @return boolean
	 */
	private boolean hasWhiteSpace(Character c) {
		return Character.isWhitespace(c);
	}
	
	/**
	 * Verifica se o caracter é um caracter aceito na lista pré definida a seguir:
	 * ! - Exclamação 
	 * @ - Arroba 
	 * # - Sustenido
	 * $ - Cifrão 
	 * % - Porcentagem 
	 * ^ - Circunflexo 
	 * & - Ecomercial
	 * * - Asterisco 
	 * ( - Abre Parentese 
	 * ) - Fechan Parentese
	 * + - Signal de Soma
	 * 
	 * @param Character
	 * @return boolean
	 */
	private boolean hasCharValidSpecials(Character c) {
		String charSpecials = "!@#$%^&*()-+";
		return (charSpecials.indexOf(c) != -1);
	}
	
	/**
	 * Verifica se há caracteres repetidos
	 * 
	 * @param Character
	 * @return boolean
	 */
	private boolean hasCharacterUnique(Set<Character> charsUnique, Character c) {
		return (!charsUnique.add(c));
	}
}
