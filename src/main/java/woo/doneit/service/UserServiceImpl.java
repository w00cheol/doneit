package woo.doneit.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import woo.doneit.domain.SignUpRequestUserDto;
import woo.doneit.domain.User;
import woo.doneit.repository.UserRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User signUp(SignUpRequestUserDto signUpRequestUserDto) {
        return null;
    }

    @Override
    public User update(Long userId) {
        return null;
    }

    @Override
    public User findOneById(Long id) {
        return null;
    }
}