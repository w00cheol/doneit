package woo.doneit.controller;

import io.swagger.annotations.Api;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import woo.doneit.domain.SignUpRequestUserDto;
import woo.doneit.service.UserService;

@RestController
@Api(tags = "test")
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
    @GetMapping("/signup")
    public ResponseEntity signUp(@RequestBody @Valid SignUpRequestUserDto signUpRequestUserDto) {
//        User user = userService.signUp(signUpRequestUserDto);
//
        return null;
    }
}
