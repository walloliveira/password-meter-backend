package br.com.db1.passwordmeter.domain.requirement;

import br.com.db1.passwordmeter.domain.password.Password;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RequirementPasswordTest {

    @Test
    @DisplayName("Requirement password bonus should be 344")
    void getBonus() {
        var password = Password.of("$1$b@#$AFT$atrfb$3          @1__3^");
        var symbol = new RequirementPassword(password);
        assertThat(symbol.getBonus()).isEqualTo(341);
        assertThat(symbol.getPasswordValue()).isEqualTo("$1$b@#$AFT$atrfb$3          @1__3^");
        assertThat(symbol.getOccurrences()).isEqualTo(79);
        assertThat(symbol.isValid()).isTrue();
    }

    @Test
    @DisplayName("Requirement password bonus should be 48")
    void getBonus48() {
        var password = Password.of("pya2703");
        var symbol = new RequirementPassword(password);
        assertThat(symbol.getBonus()).isEqualTo(48);
        assertThat(symbol.getOccurrences()).isEqualTo(24);
    }

    @Test
    @DisplayName("Requirement password bonus should be 5")
    void getBonus5() {
        var password = Password.of("pya");
        var symbol = new RequirementPassword(password);
        assertThat(symbol.getBonus()).isEqualTo(5);
        assertThat(symbol.getOccurrences()).isEqualTo(12);
    }
}
