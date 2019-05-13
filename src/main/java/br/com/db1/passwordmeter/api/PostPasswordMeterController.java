package br.com.db1.passwordmeter.api;

import br.com.db1.passwordmeter.domain.password.Password;
import br.com.db1.passwordmeter.domain.password.PasswordResult;
import br.com.db1.passwordmeter.usecase.VerifyPasswordUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/password")
class PostPasswordMeterController {

    private final VerifyPasswordUseCase useCase;

    @Autowired
    PostPasswordMeterController(VerifyPasswordUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public ResponseEntity<PasswordResource> post(
        @RequestBody @Valid VerifyPasswordDTO verifyPasswordDTO
    ) {
        Password password = Password.of(verifyPasswordDTO.value);
        PasswordResult passwordResult = this.useCase.execute(password);
        return ResponseEntity.ok(PasswordResource.fromDomain(passwordResult));
    }
}
