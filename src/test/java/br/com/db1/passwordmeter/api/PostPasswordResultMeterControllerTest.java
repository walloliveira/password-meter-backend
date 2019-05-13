package br.com.db1.passwordmeter.api;

import br.com.db1.passwordmeter.JSONCreator;
import br.com.db1.passwordmeter.domain.password.Password;
import br.com.db1.passwordmeter.domain.password.PasswordResult;
import br.com.db1.passwordmeter.usecase.VerifyPasswordUseCase;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class PostPasswordResultMeterControllerTest {

    private MockMvc mockMvc;

    @Mock
    private VerifyPasswordUseCase useCaseMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders
            .standaloneSetup(new PostPasswordMeterController(useCaseMock))
            .build();
    }

    @Test
    @DisplayName("verify a request with password test")
    void postTest() throws Exception {
        String password = "password";
        String teste = "teste";
        JSONObject payload = JSONCreator.builder()
            .put(password, teste)
            .build();
        when(useCaseMock.execute(any()))
            .thenReturn(PasswordResult.builder()
                .withPasswordRequest(Password.of("teste"))
                .build());
        this.mockMvc.perform(post("/api/password")
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .content(payload.toString()))
            .andExpect(status()
                .isOk())
            .andExpect(jsonPath("$.complexity", is("VERY_WEAK")))
            .andExpect(jsonPath("$.percentage", is(7)));
        var argumentCaptor = ArgumentCaptor.forClass(Password.class);
        verify(useCaseMock).execute(argumentCaptor.capture());
        Password passwordRequest = argumentCaptor.getValue();
        assertThat(passwordRequest.value).isEqualToIgnoringCase("teste");
    }

    @AfterEach
    void tearDown() {
        verifyNoMoreInteractions(useCaseMock);
    }
}
