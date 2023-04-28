package woo.doneit.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignUpResponseUserDto {

    private String signInId;
    private String name;

    @Builder
    public SignUpResponseUserDto(String signInId, String name) {
        this.signInId = signInId;
        this.name = name;
    }

    public static SignUpResponseUserDto fromEntity(User user) {
        return SignUpResponseUserDto
                .builder()
                .name(user.getName())
                .signInId(user.getSignInId())
                .build();
    }
}
