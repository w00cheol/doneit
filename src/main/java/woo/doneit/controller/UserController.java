package woo.doneit.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.ResponseEntity;
import woo.doneit.domain.SignUpRequestUserDto;

public interface UserController {

    ResponseEntity signUp(SignUpRequestUserDto signUpRequestUserDto);

    ResponseEntity signIn(ObjectNode objectNode);
}
