package br.com.testLucelia.passwordValidate.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.testLucelia.passwordValidate.component.PasswordValidateComponent;
import br.com.testLucelia.passwordValidate.component.impl.PasswordValidateComponentRulesImpl;
import br.com.testLucelia.passwordValidate.dto.Password;

@WebMvcTest(PasswordValidateController.class)
@TestInstance(value = Lifecycle.PER_CLASS)
class PasswordValidateControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ObjectMapper objectMapper;
	
	@MockBean
	private PasswordValidateComponent component;
	
	@BeforeAll
	void init(){
		component = Mockito.mock(PasswordValidateComponentRulesImpl.class);
		objectMapper = Mockito.mock(ObjectMapper.class);
	}

	@Test
	public void testCreateUserSuccess() throws Exception {
		String password = "{\r\n" + "    	\"password\":\"Senha#1234\"\r\n" + "    }";

		Password pwd = new Password();

		when(objectMapper.readValue(password, Password.class)).thenReturn(pwd);

		 mockMvc.perform(post("/v1/password/isValidPassword", "Teste123")
				.content(password)
				.contentType(MediaType.APPLICATION_JSON))
		 		.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();
	}
    
}
