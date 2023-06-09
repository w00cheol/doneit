package woo.doneit.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import woo.doneit.domain.SignUpRequestUserDto;
import woo.doneit.domain.SignUpResponseUserDto;
import woo.doneit.domain.User;
import woo.doneit.exception.UserNotFoundException;
import woo.doneit.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    // 회원가입
    @Override
    public SignUpResponseUserDto signUp(SignUpRequestUserDto signUpRequestUserDto) {
        User user = signUpRequestUserDto.toEntity();

        validateDuplicateUser(user);

        userRepository.save(user);

        return SignUpResponseUserDto.fromEntity(user);
    }

    @Override
    public Long signIn(String signInIdOrName, String password) {
        User findUser = userRepository.findOneBySignInId(signInIdOrName)
                .orElseGet(() -> userRepository.findOneByName(signInIdOrName)
                        .orElseThrow(() -> new UserNotFoundException("no users match this id or name")));

        if (password.equals(findUser.getPassword())) {
            return findUser.getId();
        } else {
            throw new UserNotFoundException("wrong password");
        }
    }

    // 중복 검사
    private void validateDuplicateUser(User user) {
        Optional<User> findUserBySignInId = userRepository.findOneBySignInId(user.getSignInId());
        if (!findUserBySignInId.isEmpty()) {
            throw new IllegalStateException("signInID already exists");
        }

        Optional<User> findUserByName = userRepository.findOneByName(user.getName());
        if (!findUserByName.isEmpty()) {
            throw new IllegalStateException("name already exists");
        }
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