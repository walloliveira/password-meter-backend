package br.com.db1.passwordmeter.domain.addition;

import br.com.db1.passwordmeter.domain.password.Password;
import br.com.db1.passwordmeter.domain.rate.FlatRateCalculator;
import br.com.db1.passwordmeter.domain.requirement.AbstractRequirement;

public class Number extends AbstractRequirement {

    public Number(Password password) {
        super(password, new FlatRateCalculator(4));
    }

    @Override
    public int getOccurrences() {
        String value = this.getPasswordValue();
        String symbols = value.replaceAll("[^\\d]+", "");
        return symbols.length();
    }
}
