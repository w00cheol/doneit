package woo.doneit.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import woo.doneit.domain.SignUpRequestUserDto;

public interface UserController {

    @PostMapping("/signup")
    ResponseEntity signUp(SignUpRequestUserDto signUpRequestUserDto);
}
