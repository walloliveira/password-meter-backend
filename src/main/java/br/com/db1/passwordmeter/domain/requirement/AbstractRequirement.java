package br.com.db1.passwordmeter.domain.requirement;

import br.com.db1.passwordmeter.domain.password.Password;
import br.com.db1.passwordmeter.domain.rate.RateCalculator;

public abstract class AbstractRequirement implements Requirement {

    private final Password password;
    private final RateCalculator rateCalculator;

    public AbstractRequirement(
        Password password,
        RateCalculator rateCalculator
    ) {
        this.password = password;
        this.rateCalculator = rateCalculator;
    }

    public String getPasswordValue() {
        return password.value;
    }

    @Override
    public int getBonus() {
        return this.rateCalculator.calculate(this);
    }

    @Override
    public boolean isValid() {
        return this.getOccurrences() > 0;
    }
}
