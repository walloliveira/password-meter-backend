package br.com.db1.passwordmeter.domain.deduction;

import br.com.db1.passwordmeter.domain.password.Password;
import br.com.db1.passwordmeter.domain.rate.FlatRateCalculator;
import br.com.db1.passwordmeter.domain.rate.OperatorType;
import br.com.db1.passwordmeter.domain.requirement.AbstractRequirement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsecutiveNumbers extends AbstractRequirement {

    public ConsecutiveNumbers(Password password) {
        super(
            password,
            new FlatRateCalculator(2, OperatorType.NEGATIVE)
        );
    }

    @Override
    public int getOccurrences() {
        String value = this.getPasswordValue();
        String regex = "[\\d]{2,}+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        int count = 0;
        StringBuilder group = new StringBuilder();
        while (matcher.find()) {
            count++;
            for (int i = 0; i <= matcher.groupCount(); i++) {
                group.append(matcher.group(i));
            }
        }
        return group.length() - count;
    }
}
