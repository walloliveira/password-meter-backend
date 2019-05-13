package br.com.db1.passwordmeter.domain.addition;

import br.com.db1.passwordmeter.domain.password.Password;
import br.com.db1.passwordmeter.domain.rate.FlatRateCalculator;
import br.com.db1.passwordmeter.domain.requirement.AbstractRequirement;

public final class NumberOfCharacters extends AbstractRequirement {

    public NumberOfCharacters(Password password) {
        super(password, new FlatRateCalculator(4));
    }

    @Override
    public int getOccurrences() {
        return this.getPasswordValue()
            .length();
    }

    @Override
    public boolean isValid() {
        return this.getOccurrences() > 7;
    }
}
