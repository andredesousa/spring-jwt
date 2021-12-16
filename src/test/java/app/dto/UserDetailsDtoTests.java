package app.dto;

import static org.assertj.core.api.Assertions.assertThat;

import app.entity.Role;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.GrantedAuthority;

@DisplayName("UserDetailsDto")
@ExtendWith(MockitoExtension.class)
public class UserDetailsDtoTests {

    transient UserDetailsDto userDetails;

    @BeforeEach
    void beforeEach() {
        GrantedAuthority authority = new SimpleGrantedAuthority(Role.READ.toString());

        userDetails = new UserDetailsDto("user", "secret", "xxx.yyy.zzz", List.of(authority));
    }

    @Test
    @DisplayName("#getAuthorities returns the authorities")
    void getAuthorities() {
        GrantedAuthority authority = new SimpleGrantedAuthority(Role.READ.toString());

        assertThat(userDetails.getAuthorities()).isEqualTo(List.of(authority));
    }

    @Test
    @DisplayName("#getPassword returns the password")
    void getPassword() {
        assertThat(userDetails.getPassword()).isEqualTo("secret");
    }

    @Test
    @DisplayName("#getUsername returns the user name")
    void getUsername() {
        assertThat(userDetails.getUsername()).isEqualTo("user");
    }

    @Test
    @DisplayName("#isAccountNonExpired returns true")
    void isAccountNonExpired() {
        assertThat(userDetails.isAccountNonExpired()).isEqualTo(true);
    }

    @Test
    @DisplayName("#isAccountNonLocked returns true")
    void isAccountNonLocked() {
        assertThat(userDetails.isAccountNonLocked()).isEqualTo(true);
    }

    @Test
    @DisplayName("#isCredentialsNonExpired returns true")
    void isCredentialsNonExpired() {
        assertThat(userDetails.isCredentialsNonExpired()).isEqualTo(true);
    }

    @Test
    @DisplayName("#isEnabled returns true")
    void isEnabled() {
        assertThat(userDetails.isEnabled()).isEqualTo(true);
    }

    @Test
    @DisplayName("#getAccessToken returns a string")
    void getAccessToken() {
        assertThat(userDetails.getAccessToken()).isEqualTo("xxx.yyy.zzz");
    }
}
