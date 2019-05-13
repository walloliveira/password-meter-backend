package br.com.db1.passwordmeter.domain.deduction;

import br.com.db1.passwordmeter.domain.password.Password;
import br.com.db1.passwordmeter.domain.rate.FlatRateCalculator;
import br.com.db1.passwordmeter.domain.rate.OperatorType;
import br.com.db1.passwordmeter.domain.requirement.AbstractRequirement;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class SequentialLettersThreePlus extends AbstractRequirement {

    public SequentialLettersThreePlus(Password password) {
        super(
            password,
            new FlatRateCalculator(3, OperatorType.NEGATIVE)
        );
    }

    @Override
    public int getOccurrences() {
        String value = this.getPasswordValue();
        String regex = "(?:a(?=b)|b(?=c)|c(?=d)|d(?=e)|e(?=f)|f(?=g)|g(?=h)|h(?=i)|i(?=j)|j(?=k)|k(?=l)|l(?=m)|m(?=n)|n(?=o)|o(?=p)|p(?=q)|q(?=r)|r(?=s)|s(?=t)|t(?=u)|u(?=v)|v(?=w)|w(?=x)|x(?=y)|y(?=z)){2}\\w|(?:z(?=y)|y(?=x)|x(?=w)|w(?=v)|v(?=u)|u(?=t)|t(?=s)|s(?=r)|r(?=q)|q(?=p)|p(?=o)|p(?=n)|n(?=m)|m(?=l)|l(?=k)|k(?=j)|j(?=i)|i(?=h)|h(?=g)|g(?=f)|f(?=e)|e(?=d)|d(?=c)|c(?=b)|b(?=a)){2}\\w";
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
