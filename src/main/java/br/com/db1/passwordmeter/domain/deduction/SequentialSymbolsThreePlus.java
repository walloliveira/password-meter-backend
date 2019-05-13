package br.com.db1.passwordmeter.domain.deduction;

import br.com.db1.passwordmeter.domain.password.Password;
import br.com.db1.passwordmeter.domain.rate.FlatRateCalculator;
import br.com.db1.passwordmeter.domain.rate.OperatorType;
import br.com.db1.passwordmeter.domain.requirement.AbstractRequirement;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class SequentialSymbolsThreePlus extends AbstractRequirement {

    public SequentialSymbolsThreePlus(Password password) {
        super(
            password,
            new FlatRateCalculator(3, OperatorType.NEGATIVE)
        );
    }

    @Override
    public int getOccurrences() {
        String value = this.getPasswordValue();
        String regex = "(?:!(?=@)|@(?=#)|.\\$(?=%)|%(?=&)\\w)|(?:&(?=\\*)|\\*(?=\\()\\w)";
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
                boolean groupNotExists = matchers.stream()
                    .noneMatch(it -> it.equals(group));
                if (groupNotExists) {
                    matchers.add(group);
                    count++;
                }
            }
        }
        return count;
    }
}
