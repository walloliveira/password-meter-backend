package br.com.db1.passwordmeter.domain.addition;

import br.com.db1.passwordmeter.domain.password.Password;
import br.com.db1.passwordmeter.domain.rate.FlatRateCalculator;
import br.com.db1.passwordmeter.domain.requirement.AbstractRequirement;
import br.com.db1.passwordmeter.domain.requirement.Requirement;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

public class RequirementAddition extends AbstractRequirement {

    private final List<AbstractRequirement> requirements;

    public RequirementAddition(Password password) {
        super(password, new FlatRateCalculator(2));
        this.requirements = Lists.newArrayList(
            new NumberOfCharacters(password),
            new UppercaseLetters(password),
            new LowercaseLetters(password),
            new Number(password),
            new Symbol(password)
        );
    }

    @Override
    public int getOccurrences() {
        List<Requirement> additions = this.requirements.stream()
            .filter(Requirement::isValid)
            .collect(Collectors.toList());
        return additions.size();
    }

    @Override
    public int getBonus() {
        if (!isValid()) return 0;
        return super.getBonus();
    }

    @Override
    public boolean isValid() {
        return getOccurrences() > 3;
    }
}
