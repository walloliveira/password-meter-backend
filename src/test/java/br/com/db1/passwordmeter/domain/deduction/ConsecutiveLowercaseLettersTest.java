package br.com.db1.passwordmeter.domain.deduction;

import br.com.db1.passwordmeter.domain.password.Password;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConsecutiveLowercaseLettersTest {

    @Test
    @DisplayName("Consecutive Lowercase Letters only bonus should be -8")
    void getBonusResultMinus8() {
        var password = Password.of("$1$b@#$AFT$atrfb$3          @1__3^");
        var consecutiveLowercaseLetters = new ConsecutiveLowercaseLetters(password);
        assertThat(consecutiveLowercaseLetters.getBonus()).isEqualTo(-8);
    }

    @Test
    @DisplayName("Consecutive Lowercase Letters only bonus should be 0")
    void getBonusResult0() {
        var password = Password.of("$1$b@#$b$b$3          @1__3^");
        var consecutiveLowercaseLetters = new ConsecutiveLowercaseLetters(password);
        assertThat(consecutiveLowercaseLetters.getBonus()).isEqualTo(0);
    }

    @Test
    @DisplayName("Consecutive Lowercase Letters only bonus should be -8")
    void getBonusResult4() {
        var password = Password.of("pya2703");
        var consecutiveLowercaseLetters = new ConsecutiveLowercaseLetters(password);
        assertThat(consecutiveLowercaseLetters.getBonus()).isEqualTo(-4);
        assertThat(consecutiveLowercaseLetters.getOccurrences()).isEqualTo(2);
    }
}
