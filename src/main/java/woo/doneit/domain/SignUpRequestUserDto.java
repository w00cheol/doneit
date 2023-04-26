package woo.doneit.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignUpRequestUserDto {

    @NotBlank(message = "name must not be blank")
    private String name;

    @NotBlank(message = "loginId must not be blank")
    private String loginId;

    @NotBlank(message = "password must not be blank")
    private String password;

    @Builder
    public SignUpRequestUserDto(String name, String loginId, String password) {
        this.name = name;
        this.loginId = loginId;
        this.password = password;
    }

    public User toEntity() {
        return User.builder()
                .name(this.name)
                .loginId(this.loginId)
                .password(this.password)
                .build();
    }
}