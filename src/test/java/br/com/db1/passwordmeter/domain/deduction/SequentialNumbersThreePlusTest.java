package br.com.db1.passwordmeter.domain.deduction;

import br.com.db1.passwordmeter.domain.password.Password;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SequentialNumbersThreePlusTest {

    @Test
    @DisplayName("Consecutive letters 3 plus only bonus should be -9")
    void getBonusResultMinus8() {
        var password = Password.of("p@a12345");
        var consecutiveNumbers3Plus = new SequentialNumbersThreePlus(password);
        assertThat(consecutiveNumbers3Plus.getBonus()).isEqualTo(-9);
        assertThat(consecutiveNumbers3Plus.getOccurrences()).isEqualTo(3);
    }

    @Test
    @DisplayName("Consecutive letters 3 plus only bonus should be -6")
    void getBonusResultMinus9() {
        var password = Password.of("p@ba321aabc567");
        var consecutiveNumbers3Plus = new SequentialNumbersThreePlus(password);
        assertThat(consecutiveNumbers3Plus.getBonus()).isEqualTo(-6);
        assertThat(consecutiveNumbers3Plus.getOccurrences()).isEqualTo(2);
    }

    @Test
    @DisplayName("Consecutive letters 3 plus only bonus should be -15")
    void getBonusResult0() {
        var password = Password.of("$1$123987654123@#$AFT$atrfb$3          @1__3^");
        var consecutiveNumbers3Plus = new SequentialNumbersThreePlus(password);
        assertThat(consecutiveNumbers3Plus.getBonus()).isEqualTo(-15);
    }

    @Test
    @DisplayName("Consecutive letters 3 plus only bonus should be -15")
    void getBonusResult() {
        var password = Password.of("123987654");
        var consecutiveNumbers3Plus = new SequentialNumbersThreePlus(password);
        assertThat(consecutiveNumbers3Plus.getBonus()).isEqualTo(-15);
    }
}
