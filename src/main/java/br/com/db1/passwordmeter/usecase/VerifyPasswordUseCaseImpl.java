package br.com.db1.passwordmeter.usecase;

import br.com.db1.passwordmeter.domain.password.Password;
import br.com.db1.passwordmeter.domain.password.PasswordResult;
import org.springframework.stereotype.Component;

@Component
final class VerifyPasswordUseCaseImpl implements VerifyPasswordUseCase {

    @Override
    public PasswordResult execute(Password request) {
        return PasswordResult.builder()
            .withPasswordRequest(request)
            .build();
    }
}
