package br.com.db1.passwordmeter.domain.deduction;

import br.com.db1.passwordmeter.domain.password.Password;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LetterOnlyTest {

    @Test
    @DisplayName("Letter only bonus should be -9")
    void getBonusNegative() {
        var password = Password.of("abcabcabc");
        var letterOnly = new LetterOnly(password);
        assertThat(letterOnly.getBonus()).isEqualTo(-9);
    }

    @Test
    @DisplayName("Letter only bonus should be 0")
    void getBonusZero() {
        var password = Password.of("$1$b@#$AFT$atrfb$3          @1__3^");
        var letterOnly = new LetterOnly(password);
        assertThat(letterOnly.getBonus()).isEqualTo(0);
    }

    @Test
    @DisplayName("Letter only bonus should be 0")
    void getBonusZeroPassword1() {
        var password = Password.of("$pya2703");
        var letterOnly = new LetterOnly(password);
        assertThat(letterOnly.getBonus()).isEqualTo(0);
        assertThat(letterOnly.getOccurrences()).isEqualTo(0);
    }
}
