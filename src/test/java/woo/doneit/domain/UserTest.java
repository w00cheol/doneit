package woo.doneit.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class UserTest {

    @Autowired private EntityManager em;

    private User getUser() {
        return User.builder()
                .name("권우철")
                .signInId("woo")
                .password("1234")
                .build();
    }

    @Test()
    public void 회원가입() throws Exception {
        //given
        User user = getUser();

        //when
        em.persist(user);
        Long saveId = user.getId();
        em.flush();
        em.clear();

        //then
        assertThat(user.getSignInId()).isEqualTo(em.find(User.class, saveId).getSignInId());
        assertThat(user.getName()).isEqualTo(em.find(User.class, saveId).getName());
        assertThat(user.getPassword()).isEqualTo(em.find(User.class, saveId).getPassword());
        assertThat(user.getCreateDateTime()).isEqualTo(em.find(User.class, saveId).getCreateDateTime());
    }
}