package br.com.db1.passwordmeter.domain.addition;

import br.com.db1.passwordmeter.domain.password.Password;
import br.com.db1.passwordmeter.domain.rate.FlatRateCalculator;
import br.com.db1.passwordmeter.domain.requirement.AbstractRequirement;

public final class MiddleNumbersOrSymbols extends AbstractRequirement {

    public MiddleNumbersOrSymbols(Password password) {
        super(password, new FlatRateCalculator(2));
    }

    @Override
    public int getOccurrences() {
        if (getPasswordLength() < 2) return 0;
        String value = this.getPasswordValue();
        String passwordWithoutSpace = value.replaceAll("[\\s]+", "");
        int length = passwordWithoutSpace.length() - 1;
        String substring = passwordWithoutSpace.substring(1, length);
        String middleNumbers = substring
            .replaceAll("[^\\d]+", "");
        String middleSymbols = substring
            .replaceAll("[\\w]+", "");
        return middleNumbers.length() + middleSymbols.length();
    }
}
