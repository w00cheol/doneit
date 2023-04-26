package woo.doneit.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import woo.doneit.domain.User;
import woo.doneit.domain.SignUpRequestUserDto;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final EntityManager em;

    @Override
    public void signUp(SignUpRequestUserDto signUpRequestUserDto) {

    }

    @Override
    public User findOneById(Long id) {
        return em.find(User.class, id);
    }


}
