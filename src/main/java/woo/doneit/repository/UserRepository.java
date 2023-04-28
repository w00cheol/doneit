package woo.doneit.repository;

import woo.doneit.domain.User;

import java.util.Optional;

public interface UserRepository {

    void save(User User);

    User findOneById(Long id);

    Optional<User> findOneByName(String name);

    Optional<User> findOneBySignInId(String signInId);
}
