package br.com.db1.passwordmeter.usecase;

import br.com.db1.passwordmeter.domain.password.Password;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class VerifyPasswordUseCaseTest {

    @Test
    @DisplayName("Password result should not null")
    void execute() {
        final VerifyPasswordUseCase useCase = new VerifyPasswordUseCaseImpl();
        final var password = "teste";
        final var request = Password.of(password);
        final var passwordResult = useCase.execute(request);
        assertThat(passwordResult).isNotNull();
        assertThat(passwordResult.getRate()).isEqualTo(7);
    }
}
