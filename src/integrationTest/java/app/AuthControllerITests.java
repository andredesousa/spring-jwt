package app;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import app.dto.AuthDto;
import app.entity.User;
import app.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DisplayName("Auth Resource")
public class AuthControllerITests {

    @Autowired
    transient MockMvc mockMvc;

    @MockBean
    transient UserRepository userRepository;

    transient String bearerToken = "Bearer eyJhbGciOiJIUzUxMiJ9." +
            "eyJzdWIiOiJ1c2VybmFtZSIsImlhdCI6MTYzMzc5NDQwMSwiZXhwIjoxOTQ5MTU0NDAxLCJhdXRob3JpdGllcyI6W119." +
            "KR1DBB-ui8ycBhIcRhzOwhcqCNC2DTy5aDYlKeARg1_I0-Aa_KiBHvfZEJbsH4oO3vQxn5yaHmnxtIrlJOtoiQ";

    @Test
    @DisplayName("/login (POST)")
    void login() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        AuthDto auth = new AuthDto("username", "12345678");
        User user = new User(1, "username", "$2a$10$E8TNH1WhRpSGU/RQydurJeJh2.PHi1idJ4wRy2/fVcy.re3RgVLsW", null, true, List.of());

        when(userRepository.findByUsername("username")).thenReturn(Optional.of(user));

        MvcResult response = mockMvc
                .perform(post("/login")
                        .content(objectMapper.writeValueAsString(auth)).contentType(APPLICATION_JSON))
                .andReturn();

        assertThat(response.getResponse().getStatus()).isEqualTo(200);
    }

    @Test
    @DisplayName("/refresh (POST)")
    void refresh() throws Exception {
        MvcResult response = mockMvc
                .perform(post("/refresh")
                        .header(AUTHORIZATION, bearerToken)
                        .contentType(APPLICATION_JSON))
                .andReturn();

        assertThat(response.getResponse().getStatus()).isEqualTo(200);
    }
}
