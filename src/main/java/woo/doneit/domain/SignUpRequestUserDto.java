package woo.doneit.domain;

import javax.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignUpRequestUserDto {

    @NotBlank(message = "name must not be blank")
    private String name;

    @NotBlank(message = "signInId must not be blank")
    private String signInId;

    @NotBlank(message = "password must not be blank")
    private String password;

    @Builder
    public SignUpRequestUserDto(String name, String signInId, String password) {
        this.name = name;
        this.signInId = signInId;
        this.password = password;
    }

    public User toEntity() {
        return User.builder()
                .name(this.name)
                .signInId(this.signInId)
                .password(this.password)
                .build();
    }
}