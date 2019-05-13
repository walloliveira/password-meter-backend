package br.com.db1.passwordmeter.usecase;

import br.com.db1.passwordmeter.domain.password.Password;
import br.com.db1.passwordmeter.domain.password.PasswordResult;

public interface VerifyPasswordUseCase {

    PasswordResult execute(Password request);
}
