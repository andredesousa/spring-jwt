package app.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayName("AuthDto")
@ExtendWith(MockitoExtension.class)
public class AuthDtoTests {

    @Test
    @DisplayName("#AuthDto constructor")
    void authDto() {
        AuthDto auth = new AuthDto("user", "secret");

        assertThat(auth.username).isEqualTo("user");
        assertThat(auth.password).isEqualTo("secret");
    }
}
