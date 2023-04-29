package woo.doneit.service;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import woo.doneit.domain.SignUpRequestUserDto;
import woo.doneit.domain.SignUpResponseUserDto;
import woo.doneit.domain.User;
import woo.doneit.repository.UserRepository;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class UserServiceImplTest {

    @Autowired UserService userService;
    @Autowired UserRepository userRepository;

    private static SignUpRequestUserDto getSignUpRequestUserDto(String name, String signInId, String password) {
        return SignUpRequestUserDto.builder()
                .name(name)
                .signInId(signInId)
                .password(password)
                .build();
    }

    @Test
    public void 회원가입() {
        //given
        SignUpRequestUserDto reqDto = getSignUpRequestUserDto("권우철", "woo", "1234");

        //when
        SignUpResponseUserDto resDto = userService.signUp(reqDto);

        //then
        Assertions.assertThat(reqDto.getName()).isEqualTo(resDto.getName());
        Assertions.assertThat(reqDto.getSignInId()).isEqualTo(resDto.getSignInId());

        User findUser = userRepository.findOneByName(resDto.getName())
                .orElseThrow(() -> new IllegalStateException("No Users match this name"));

        Assertions.assertThat(findUser.getId()).isNotNull();
        Assertions.assertThat(findUser.getPassword()).isNotBlank();
        Assertions.assertThat(findUser.getCreateDateTime()).isNotNull();
        Assertions.assertThat(findUser.getName()).isNotBlank();
        Assertions.assertThat(findUser.getSignInId()).isNotBlank();
    }

    @Test
    public void 중복_검사() {
        //given
        SignUpRequestUserDto reqDtoOrigin = getSignUpRequestUserDto("권우철", "woo", "1234");
        SignUpRequestUserDto reqDtoSameName = getSignUpRequestUserDto("권우철", "keto", "1234");
        SignUpRequestUserDto reqDtoSameSignInId = getSignUpRequestUserDto("이디야", "woo", "1234");
        SignUpRequestUserDto reqDtoSamePassword = getSignUpRequestUserDto("이디야", "keto", "1234");

        //when
        SignUpResponseUserDto resDto = userService.signUp(reqDtoOrigin);

        //then
        assertThrows(IllegalStateException.class, () -> {
            userService.signUp(reqDtoSameName);
        });

        assertThrows(IllegalStateException.class, () -> {
            userService.signUp(reqDtoSameSignInId);
        });

        assertDoesNotThrow(() -> {
            userService.signUp(reqDtoSamePassword);
        });
    }

    @Test
    public void validate() {
        //given
        SignUpRequestUserDto reqDtoInvalidName = getSignUpRequestUserDto(" ", " woo", " 1234");
        SignUpRequestUserDto reqDtoInvalidSignInId = getSignUpRequestUserDto(" validName", " ", "123s4 ");
        SignUpRequestUserDto reqDtoInvalidPassword = getSignUpRequestUserDto("validName ", "woo ", "");

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            userService.signUp(reqDtoInvalidName);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            userService.signUp(reqDtoInvalidSignInId);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            userService.signUp(reqDtoInvalidPassword);
        });
    }
}