package br.com.db1.passwordmeter.domain.addition;

import br.com.db1.passwordmeter.domain.password.Password;
import br.com.db1.passwordmeter.domain.rate.ConditionIncrementRateCalculator;
import br.com.db1.passwordmeter.domain.requirement.AbstractRequirement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class UppercaseLetters extends AbstractRequirement {

    public UppercaseLetters(Password password) {
        super(password, new ConditionIncrementRateCalculator(2));
    }

    @Override
    public int getOccurrences() {
        String value = this.getPasswordValue();
        Pattern pattern = Pattern.compile("[A-Z]");
        Matcher matcher = pattern.matcher(value);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }
}
