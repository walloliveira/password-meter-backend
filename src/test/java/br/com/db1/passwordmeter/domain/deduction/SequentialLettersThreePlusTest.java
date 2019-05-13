package br.com.db1.passwordmeter.domain.deduction;

import br.com.db1.passwordmeter.domain.password.Password;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SequentialLettersThreePlusTest {

    @Test
    @DisplayName("Consecutive letters 3 plus only bonus should be -3")
    void getBonusResultMinus8() {
        var password = Password.of("$1$123@#$abcFT$$3          @1__3^");
        var consecutiveLetters3Plus = new SequentialLettersThreePlus(password);
        assertThat(consecutiveLetters3Plus.getBonus()).isEqualTo(-3);
        assertThat(consecutiveLetters3Plus.getOccurrences()).isEqualTo(1);
    }

    @Test
    @DisplayName("Consecutive letters 3 plus only bonus should be 0")
    void getBonusResult0() {
        var password = Password.of("$1$123987654@#$AFT$atrfb$3          @1__3^");
        var consecutiveLetters3Plus = new SequentialLettersThreePlus(password);
        assertThat(consecutiveLetters3Plus.getBonus()).isEqualTo(0);
        assertThat(consecutiveLetters3Plus.getOccurrences()).isEqualTo(0);
    }

    @Test
    @DisplayName("Consecutive letters 3 plus only bonus should be -3")
    void getBonusResult() {
        var password = Password.of("$1$123@#$abcabcabcabcFT$$3          @1__3^");
        var consecutiveLetters3Plus = new SequentialLettersThreePlus(password);
        assertThat(consecutiveLetters3Plus.getBonus()).isEqualTo(-3);
        assertThat(consecutiveLetters3Plus.getOccurrences()).isEqualTo(1);
    }
}
