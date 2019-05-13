package br.com.db1.passwordmeter.domain.deduction;

import br.com.db1.passwordmeter.domain.password.Password;
import br.com.db1.passwordmeter.domain.rate.FlatRateCalculator;
import br.com.db1.passwordmeter.domain.rate.OperatorType;
import br.com.db1.passwordmeter.domain.requirement.AbstractRequirement;

public class NumberOnly extends AbstractRequirement {

    public NumberOnly(Password password) {
        super(
            password,
            new FlatRateCalculator(
                1,
                OperatorType.NEGATIVE)
        );
    }

    @Override
    public int getOccurrences() {
        String passwordValue = this.getPasswordValue();
        boolean isLettersOnly = passwordValue.matches("^([0-9]+)$");
        return isLettersOnly ? this.getPasswordLength() : 0;
    }
}
