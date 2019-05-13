package br.com.db1.passwordmeter.domain.addition;

import br.com.db1.passwordmeter.domain.password.Password;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UppercaseLettersTest {

    @Test
    @DisplayName("Uppercase letters letters bonus should be 62")
    void getBonus() {
        var password = Password.of("$1$b@#$AFT$atrfb$3          @1__3^");
        var uppercaseLetters = new UppercaseLetters(password);
        assertThat(uppercaseLetters.getBonus()).isEqualTo(62);
    }

    @Test
    @DisplayName("Uppercase letters letters bonus should be 0")
    void getBonus0() {
        var password = Password.of("pya2703");
        var uppercaseLetters = new UppercaseLetters(password);
        assertThat(uppercaseLetters.getBonus()).isEqualTo(0);
        assertThat(uppercaseLetters.getOccurrences()).isEqualTo(0);
    }
}
