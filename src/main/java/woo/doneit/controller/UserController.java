package woo.doneit.controller;

import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import woo.doneit.domain.SignUpRequestUserDto;

public interface UserController {

    @GetMapping("/signup")
    ResponseEntity signUp(@RequestBody @Valid SignUpRequestUserDto signUpRequestUserDto);
}
