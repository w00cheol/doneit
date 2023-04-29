package woo.doneit.service;

import woo.doneit.domain.SignUpRequestUserDto;
import woo.doneit.domain.SignUpResponseUserDto;
import woo.doneit.domain.User;

public interface UserService {

    SignUpResponseUserDto signUp(SignUpRequestUserDto signUpRequestUserDto);

    // TODO: 토큰 적용
    Long signIn(String signInIdOrName, String password);

    User update(Long userId);

    User findOneById(Long userId);
}
