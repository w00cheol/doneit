package woo.doneit.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@Api(tags = "Util")
@RestController
@RequestMapping("/utils")
@RequiredArgsConstructor
public class UtilController {

    private final Environment env;

    @GetMapping("/profiles")
    public String getProfile() {
        return Arrays.stream(env.getActiveProfiles()).findFirst().orElse("Nothing");
    }

}
