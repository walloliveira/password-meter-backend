package br.com.db1.passwordmeter.domain.rate;

import br.com.db1.passwordmeter.domain.requirement.Requirement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RateCalculatorTest {

    @Test
    @DisplayName("Flat rate calculator should be 10")
    void calculatePostive() {
        var calculator = new FlatRateCalculator(1);
        var requirement = mock(Requirement.class);
        when(requirement.getOccurrences()).thenReturn(10);
        int result = calculator.calculate(requirement);
        assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("Flat rate calculator should be -10")
    void calculateNegative() {
        var calculator = new FlatRateCalculator(
            1,
            OperatorType.NEGATIVE
        );
        var requirement = mock(Requirement.class);
        when(requirement.getOccurrences()).thenReturn(10);
        int result = calculator.calculate(requirement);
        assertThat(result).isEqualTo(-10);
    }
}
