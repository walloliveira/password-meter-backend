package br.com.db1.passwordmeter.domain.rate;

import br.com.db1.passwordmeter.domain.requirement.Requirement;

public final class ConditionIncrementRateCalculator extends AbstractRateCalculator {

    public ConditionIncrementRateCalculator(int factor) {
        super(factor);
    }

    @Override
    public int calculate(Requirement requirement) {
        int occurrences = requirement.getOccurrences();
        if (occurrences == 0) return 0;
        int length = requirement.getPasswordLength();
        int count = length - occurrences;
        int zero = 0;
        int factor = this.getFactor();
        boolean isPositiveResult = count > zero;
        return isPositiveResult ? count * factor : zero;
    }
}
