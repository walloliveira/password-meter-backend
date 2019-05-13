package br.com.db1.passwordmeter.domain.deduction;

import br.com.db1.passwordmeter.domain.password.Password;
import br.com.db1.passwordmeter.domain.rate.FlatRateCalculator;
import br.com.db1.passwordmeter.domain.rate.OperatorType;
import br.com.db1.passwordmeter.domain.requirement.AbstractRequirement;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class SequentialNumbersThreePlus extends AbstractRequirement {

    public SequentialNumbersThreePlus(Password password) {
        super(
            password,
            new FlatRateCalculator(3, OperatorType.NEGATIVE)
        );
    }

    @Override
    public int getOccurrences() {
        String value = this.getPasswordValue();
        String regex = "(?:0(?=1)|1(?=2)|2(?=3)|3(?=4)|4(?=5)|5(?=6)|6(?=7)|7(?=8)|8(?=9)){2}\\d|(?:9(?=8)|8(?=7)|7(?=6)|6(?=5)|5(?=4)|4(?=3)|3(?=2)|2(?=1)|1(?=0)){2}\\d";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        int count = 0;
        int length = getPasswordLength();
        List<String> matchers = Lists.newArrayList();
        for (int i = 0; i < length; i++) {
            int endIndex = i + 3;
            if (endIndex > length)
                endIndex = length;
            String substring = value.substring(i, endIndex);
            Matcher matcher = pattern.matcher(substring);
            if (matcher.find()) {
                String group = matcher.group(0);
                boolean sequentialNotExists = matchers.stream()
                    .noneMatch(it -> it.equals(group));
                if (sequentialNotExists) {
                    matchers.add(group);
                    count++;
                }
            }
        }
        return count;
    }
}
