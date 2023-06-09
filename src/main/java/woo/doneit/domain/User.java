package woo.doneit.domain;

import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.util.Assert;

import java.time.LocalDateTime;

@Entity @Table(name = "users")
@Getter
@DynamicInsert @DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", updatable = false)
    private Long id;

    @Column(length = 10, nullable = false, unique = true)
    private String name;

    @Column(length = 10, nullable = false, unique = true)
    private String signInId;

    @Column(nullable = false)
    private String password;

//    @ColumnDefault("now()") //DB시간 사용
    @Column(nullable = false, updatable = false)
    private LocalDateTime createDateTime;

    @PrePersist
    private void prePersist() {
        this.createDateTime = this.createDateTime == null ? LocalDateTime.now() : this.createDateTime;
    }

    @Builder
    public User(String name, String signInId, String password) {
        Assert.hasText(name, "name must not be null");
        Assert.hasText(signInId, "signInId must not be null");
        Assert.hasText(password, "password must not be null");

        this.name = name;
        this.signInId = signInId;
        this.password = password;
    }
}
