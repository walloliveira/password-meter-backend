package br.com.db1.passwordmeter.domain.deduction;

import br.com.db1.passwordmeter.domain.password.Password;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConsecutiveUppercaseLettersTest {
    @Test
    @DisplayName("Consecutive Uppercase Letters only bonus should be -4")
    void getBonusResult4() {
        var password = Password.of("$1$b@#$AFT$atrfb$3          @1__3^");
        var consecutiveUppercaseLetters = new ConsecutiveUppercaseLetters(password);
        assertThat(consecutiveUppercaseLetters.getBonus()).isEqualTo(-4);
    }

    @Test
    @DisplayName("Consecutive Uppercase Letters only bonus should be 0")
    void getBonusResult0() {
        var password = Password.of("$1$b@#$afb$atrfb$3          @1__3^");
        var consecutiveUppercaseLetters = new ConsecutiveUppercaseLetters(password);
        assertThat(consecutiveUppercaseLetters.getBonus()).isEqualTo(0);
    }

    @Test
    @DisplayName("Consecutive Uppercase Letters only bonus should be 0")
    void getBonusResult0Password1() {
        var password = Password.of("pya2703");
        var consecutiveUppercaseLetters = new ConsecutiveUppercaseLetters(password);
        assertThat(consecutiveUppercaseLetters.getBonus()).isEqualTo(0);
        assertThat(consecutiveUppercaseLetters.getOccurrences()).isEqualTo(0);
    }
}
