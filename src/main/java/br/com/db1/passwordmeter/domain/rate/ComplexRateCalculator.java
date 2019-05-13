package br.com.db1.passwordmeter.domain.rate;

import br.com.db1.passwordmeter.domain.requirement.Requirement;

public final class ComplexRateCalculator extends AbstractRateCalculator {

    public ComplexRateCalculator() {
        super(1);
    }

    @Override
    public int calculate(Requirement requirement) {
        return 0;
    }
}
