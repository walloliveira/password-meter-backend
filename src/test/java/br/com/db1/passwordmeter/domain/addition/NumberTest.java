package br.com.db1.passwordmeter.domain.addition;

import br.com.db1.passwordmeter.domain.password.Password;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberTest {

    @Test
    @DisplayName("Number bonus should be 16")
    void getBonus() {
        var password = Password.of("$1$b@#$AFT$atrfb$3          @1__3^");
        var number = new Number(password);
        assertThat(number.getBonus()).isEqualTo(16);
    }

    @Test
    @DisplayName("Number bonus should be 16")
    void getBonus16() {
        var password = Password.of("pya2703");
        var number = new Number(password);
        assertThat(number.getBonus()).isEqualTo(16);
        assertThat(number.getOccurrences()).isEqualTo(4);
    }
}
