package woo.doneit.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignUpResponseUserDto {

    private Long id;

    public SignUpResponseUserDto(User user) {
        this.id = user.getId();
    }
}
