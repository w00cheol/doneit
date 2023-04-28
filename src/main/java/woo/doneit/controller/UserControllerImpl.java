package woo.doneit.controller;

import io.swagger.annotations.Api;
import javax.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
}
