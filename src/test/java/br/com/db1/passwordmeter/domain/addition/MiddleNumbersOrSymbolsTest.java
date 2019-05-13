package br.com.db1.passwordmeter.domain.addition;

import br.com.db1.passwordmeter.domain.password.Password;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MiddleNumbersOrSymbolsTest {

    @Test
    @DisplayName("Middle numbers or symbols bonus should be 22")
    void getBonus() {
        Password password = Password.of("$1$b@#$AFT$atrfb$3          @1__3^");
        var middleNumbersOrSymbols = new MiddleNumbersOrSymbols(password);
        assertThat(middleNumbersOrSymbols.getBonus()).isEqualTo(22);
    }

    @Test
    @DisplayName("Middle numbers or symbols bonus should be 6")
    void getBonus6() {
        Password password = Password.of("pya2703");
        var middleNumbersOrSymbols = new MiddleNumbersOrSymbols(password);
        assertThat(middleNumbersOrSymbols.getBonus()).isEqualTo(6);
        assertThat(middleNumbersOrSymbols.getOccurrences()).isEqualTo(3);
    }

    @Test
    @DisplayName("Middle numbers or symbols bonus should be 0 and occurrences 0")
    void getBonus0() {
        Password password = Password.of("pya");
        var middleNumbersOrSymbols = new MiddleNumbersOrSymbols(password);
        assertThat(middleNumbersOrSymbols.getBonus()).isEqualTo(0);
        assertThat(middleNumbersOrSymbols.getOccurrences()).isEqualTo(0);
    }

    @Test
    @DisplayName("Middle numbers or symbols bonus should be 2 and occurrences 0")
    void getBonus2() {
        Password password = Password.of("p@a");
        var middleNumbersOrSymbols = new MiddleNumbersOrSymbols(password);
        assertThat(middleNumbersOrSymbols.getBonus()).isEqualTo(2);
        assertThat(middleNumbersOrSymbols.getOccurrences()).isEqualTo(1);
    }
}
