package br.com.db1.passwordmeter.domain.addition;

import br.com.db1.passwordmeter.domain.password.Password;
import br.com.db1.passwordmeter.domain.rate.FlatRateCalculator;
import br.com.db1.passwordmeter.domain.requirement.AbstractRequirement;

public final class Symbol extends AbstractRequirement {

    public Symbol(Password password) {
        super(password, new FlatRateCalculator(6));
    }

    @Override
    public int getOccurrences() {
        String value = this.getPasswordValue();
        String passwordWithoutSpace = value.replaceAll("[\\s]+", "");
        String symbols = passwordWithoutSpace.replaceAll("[\\w]+", "");
        return symbols.length();
    }
}
