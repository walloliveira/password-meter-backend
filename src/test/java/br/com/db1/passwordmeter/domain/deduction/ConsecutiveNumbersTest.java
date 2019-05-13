package br.com.db1.passwordmeter.domain.deduction;

import br.com.db1.passwordmeter.domain.password.Password;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConsecutiveNumbersTest {

    @Test
    @DisplayName("Consecutive numbers only bonus should be -10")
    void getBonusResult10() {
        var password = Password.of("abc123dsafsdf12sadfsadfasdf123");
        var consecutiveNumbers = new ConsecutiveNumbers(password);
        assertThat(consecutiveNumbers.getBonus()).isEqualTo(-10);
        assertThat(consecutiveNumbers.getOccurrences()).isEqualTo(5);
    }

    @Test
    @DisplayName("Consecutive numbers only bonus should be -8")
    void getBonusResult8() {
        var password = Password.of("abc123dsafsdf12a1b22");
        var consecutiveNumbers = new ConsecutiveNumbers(password);
        assertThat(consecutiveNumbers.getBonus()).isEqualTo(-8);
        assertThat(consecutiveNumbers.getOccurrences()).isEqualTo(4);
    }

    @Test
    @DisplayName("Consecutive numbers only bonus should be 0")
    void getBonusResult0() {
        var password = Password.of("$1$b@#$AFT$atrfb$3          @1__3^");
        var consecutiveNumbers = new ConsecutiveNumbers(password);
        assertThat(consecutiveNumbers.getBonus()).isEqualTo(0);
    }

    @Test
    @DisplayName("Consecutive numbers only bonus should be -6")
    void getBonusResult6() {
        var password = Password.of("pya2703");
        var consecutiveNumbers = new ConsecutiveNumbers(password);
        assertThat(consecutiveNumbers.getBonus()).isEqualTo(-6);
        assertThat(consecutiveNumbers.getOccurrences()).isEqualTo(3);
    }
}
