package woo.doneit.repository;

import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import woo.doneit.domain.User;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final EntityManager em;

    @Override
    public void save(User user) {
        em.persist(user);
    }

    @Override
    public User findOneById(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public Optional<User> findOneByName(String name) {
        return em.createQuery("select u from User u where u.name = :name", User.class)
                .setParameter("name", name)
                .getResultList()
                .stream()
                .findAny();
    }

    @Override
    public Optional<User> findOneBySignInId(String signInId) {
        return em.createQuery("select u from User u where u.signInId = :signInId", User.class)
                .setParameter("signInId", signInId)
                .getResultList()
                .stream()
                .findAny();
    }
}
