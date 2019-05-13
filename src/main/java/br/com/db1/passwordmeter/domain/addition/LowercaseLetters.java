package br.com.db1.passwordmeter.domain.addition;

import br.com.db1.passwordmeter.domain.password.Password;
import br.com.db1.passwordmeter.domain.rate.ConditionIncrementRateCalculator;
import br.com.db1.passwordmeter.domain.requirement.AbstractRequirement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LowercaseLetters extends AbstractRequirement {

    public LowercaseLetters(Password password) {
        super(password, new ConditionIncrementRateCalculator(2));
    }

    @Override
    public int getOccurrences() {
        String value = this.getPasswordValue();
        String regex = "[a-z]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }
}
