package br.com.db1.passwordmeter.domain.rate;

import br.com.db1.passwordmeter.domain.requirement.Requirement;

public final class FlatRateCalculator extends AbstractRateCalculator {

    public FlatRateCalculator(int factor) {
        super(factor);
    }

    public FlatRateCalculator(
        int factor,
        OperatorType operator
    ) {
        super(factor, operator);
    }

    @Override
    public int calculate(Requirement requirement) {
        int operatorValue = this.getOperatorValue();
        int occurrences = requirement.getOccurrences();
        return operatorValue * (occurrences * this.getFactor());
    }
}
