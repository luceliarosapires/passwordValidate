package br.com.testLucelia.passwordValidate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.testLucelia.passwordValidate.component.PasswordValidateComponent;
import br.com.testLucelia.passwordValidate.dto.Password;

@RestController
@RequestMapping("/v1/password")
public class PasswordValidateController {

	@Autowired
	PasswordValidateComponent passwordComponent;

	@PostMapping(value = "/isValidPassword")
	public ResponseEntity<Boolean> isValidPassword(@Nullable @RequestBody String password)
			throws JsonMappingException, JsonProcessingException {

		ObjectMapper mapper = new ObjectMapper();
		Password pwd = mapper.readValue(password, Password.class);
		return new ResponseEntity<Boolean>(passwordComponent.isValidPassword(pwd.getPassword()), HttpStatus.OK);
	}

}
