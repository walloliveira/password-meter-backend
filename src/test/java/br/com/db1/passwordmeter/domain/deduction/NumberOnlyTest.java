package br.com.db1.passwordmeter.domain.deduction;

import br.com.db1.passwordmeter.domain.password.Password;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberOnlyTest {

    @Test
    @DisplayName("Numer only bonus should be -9")
    void getBonusNegative() {
        var password = Password.of("123123213");
        var numberOnly = new NumberOnly(password);
        assertThat(numberOnly.getBonus()).isEqualTo(-9);
    }

    @Test
    @DisplayName("Numer only bonus should be 0")
    void getBonusZero() {
        var password = Password.of("$1$b@#$AFT$atrfb$3          @1__3^");
        var numberOnly = new NumberOnly(password);
        assertThat(numberOnly.getBonus()).isEqualTo(0);
    }
}
