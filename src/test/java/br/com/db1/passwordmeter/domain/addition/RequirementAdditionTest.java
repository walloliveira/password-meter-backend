package br.com.db1.passwordmeter.domain.addition;

import br.com.db1.passwordmeter.domain.password.Password;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RequirementAdditionTest {

    @Test
    @DisplayName("Requirement addition bonus should be 10")
    void getBonus() {
        var password = Password.of("$1$b@#$AFT$atrfb$3          @1__3^");
        var symbol = new RequirementAddition(password);
        assertThat(symbol.getBonus()).isEqualTo(10);
    }

    @Test
    @DisplayName("Requirement addition bonus should be 0")
    void getBonus0() {
        var password = Password.of("pya");
        var symbol = new RequirementAddition(password);
        assertThat(symbol.getBonus()).isEqualTo(0);
        assertThat(symbol.getOccurrences()).isEqualTo(1);
    }
}
