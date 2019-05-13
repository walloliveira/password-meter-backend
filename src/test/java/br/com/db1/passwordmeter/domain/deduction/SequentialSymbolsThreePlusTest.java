package br.com.db1.passwordmeter.domain.deduction;

import br.com.db1.passwordmeter.domain.password.Password;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SequentialSymbolsThreePlusTest {

    @Test
    @DisplayName("Sequential symbols 3 plus only bonus should be -15")
    void getBonusResult3() {
        var password = Password.of("$1$123987654@#$AFT$atrfb$3          @1__3^");
        var consecutiveLetters3Plus = new SequentialSymbolsThreePlus(password);
        assertThat(consecutiveLetters3Plus.getBonus()).isEqualTo(-3);
        assertThat(consecutiveLetters3Plus.getOccurrences()).isEqualTo(1);
    }

    @Test
    @DisplayName("SequentialSymbolsThreePlus letters 3 plus only bonus should be 0")
    void getBonus0() {
        var password = Password.of("123987654");
        var consecutiveLetters3Plus = new SequentialSymbolsThreePlus(password);
        assertThat(consecutiveLetters3Plus.getBonus()).isEqualTo(-0);
    }

    @Test
    @DisplayName("SequentialSymbolsThreePlus letters 3 plus only bonus should be 0")
    void getBonus3() {
        var password = Password.of("$1$b@#$AFT$atrfb$3          @1__3^");
        var consecutiveLetters3Plus = new SequentialSymbolsThreePlus(password);
        assertThat(consecutiveLetters3Plus.getBonus()).isEqualTo(-3);
        assertThat(consecutiveLetters3Plus.getOccurrences()).isEqualTo(1);
    }
}
