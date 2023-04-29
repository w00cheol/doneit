package woo.doneit.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import io.swagger.annotations.Api;
import javax.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import woo.doneit.domain.SignUpRequestUserDto;
import woo.doneit.domain.SignUpResponseUserDto;
import woo.doneit.service.UserService;

@RestController
@Api(tags = "User")
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @GetMapping("/")
    public ResponseEntity<String> hello() {
        return ResponseEntity
                .status(200)
                .body("Hello Done It");
    }

    @Override
    @PostMapping("/signup")
    public ResponseEntity signUp(@RequestBody @Valid SignUpRequestUserDto signUpRequestUserDto) {
        SignUpResponseUserDto signUpResponseUserDto = userService.signUp(signUpRequestUserDto);

        return ResponseEntity
                .status(201)
                .body(signUpResponseUserDto);
    }

    @Override
    @PostMapping("/signin")
    public ResponseEntity signIn(@RequestBody ObjectNode signInObj) {
        String signInIdOrName = signInObj.get("signInIdOrName").asText();
        String password = signInObj.get("password").asText();

        Assert.hasText(signInIdOrName, "signInIdOrName must not be blank");
        Assert.hasText(password, "password must not be blank");

        Long userId = userService.signIn(signInIdOrName, password);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userId);
    }
}
