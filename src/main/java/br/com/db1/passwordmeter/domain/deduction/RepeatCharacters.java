package br.com.db1.passwordmeter.domain.deduction;

import br.com.db1.passwordmeter.domain.password.Password;
import br.com.db1.passwordmeter.domain.rate.ComplexRateCalculator;
import br.com.db1.passwordmeter.domain.requirement.AbstractRequirement;

public final class RepeatCharacters extends AbstractRequirement {

    public RepeatCharacters(Password password) {
        super(password, new ComplexRateCalculator());
    }

    @Override
    public int getOccurrences() {
        return 0;
    }
}
