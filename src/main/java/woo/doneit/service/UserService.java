package woo.doneit.service;

import woo.doneit.domain.SignUpRequestUserDto;
import woo.doneit.domain.User;

public interface UserService {

    User signUp(SignUpRequestUserDto signUpRequestUserDto);

    User update(Long userId);

    User findOneById(Long userId);
}
