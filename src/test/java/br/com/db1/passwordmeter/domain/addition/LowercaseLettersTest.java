package br.com.db1.passwordmeter.domain.addition;

import br.com.db1.passwordmeter.domain.password.Password;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LowercaseLettersTest {

    @Test
    @DisplayName("Lowercase letters bonus should be 56")
    void getBonus() {
        var password = Password.of("$1$b@#$AFT$atrfb$3          @1__3^");
        var lowercaseLetters = new LowercaseLetters(password);
        assertThat(lowercaseLetters.getBonus()).isEqualTo(56);
    }

    @Test
    @DisplayName("Lowercase letters bonus should be 56")
    void getBonus8() {
        var password = Password.of("pya2703");
        var lowercaseLetters = new LowercaseLetters(password);
        assertThat(lowercaseLetters.getBonus()).isEqualTo(8);
        assertThat(lowercaseLetters.getOccurrences()).isEqualTo(3);
    }

    @Test
    @DisplayName("Lowercase letters bonus should be 56")
    void getBonus0() {
        var password = Password.of("pya");
        var lowercaseLetters = new LowercaseLetters(password);
        assertThat(lowercaseLetters.getBonus()).isEqualTo(0);
        assertThat(lowercaseLetters.getOccurrences()).isEqualTo(3);
    }
}
