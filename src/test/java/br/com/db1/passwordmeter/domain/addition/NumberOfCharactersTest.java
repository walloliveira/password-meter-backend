package br.com.db1.passwordmeter.domain.addition;

import br.com.db1.passwordmeter.domain.password.Password;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberOfCharactersTest {

    @Test
    @DisplayName("Number of chacaracter bonus should be 136")
    void getBonus() {
        var password = Password.of("$1$b@#$AFT$atrfb$3          @1__3^");
        var numberOfChacracter = new NumberOfCharacters(password);
        assertThat(numberOfChacracter.getBonus()).isEqualTo(136);
    }

    @Test
    @DisplayName("Number of chacaracter bonus should be 28")
    void getBonus28() {
        var password = Password.of("pya2703");
        var numberOfChacracter = new NumberOfCharacters(password);
        assertThat(numberOfChacracter.getBonus()).isEqualTo(28);
        assertThat(numberOfChacracter.getOccurrences()).isEqualTo(7);
    }
}
