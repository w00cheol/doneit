package woo.doneit.repository;

import woo.doneit.domain.SignUpRequestUserDto;
import woo.doneit.domain.User;

public interface UserRepository {

    void signUp(SignUpRequestUserDto signUpRequestUserDto);

    User findOneById(Long id);
}
