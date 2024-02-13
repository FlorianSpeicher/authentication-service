package com.example.microservices.authenticationservice;

import com.example.microservices.authenticationservice.controller.AuthController;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static io.restassured.RestAssured.*;

@ActiveProfiles("test")
@DisplayName("AuthControllerTest:")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = AuthenticationserviceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class AuthControllerTest {

	private final String nonValidTokenResponse = "nonValidToken";
	private AuthController authController;


	@Test
	@Order(1)
	void validateAndUpdateToken(){
		String inValidToken = "eee026a4-17e0-4713-873e-be963c320102";
		String result = given().body(inValidToken).get("/auth/token/validateAndUpdate").asString();
		Assertions.assertEquals("nonValidToken", result);
		String validToken = "159ed0c6-958f-4cb8-8cc3-2958f25a298d";
		Response response = given().body(validToken).get("/auth/token/validateAndUpdate");
		Assertions.assertEquals(200, response.statusCode());
		Assertions.assertNotEquals(nonValidTokenResponse, response.asString());
	}

}
