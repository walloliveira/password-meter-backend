package br.com.db1.passwordmeter.domain.requirement;

import br.com.db1.passwordmeter.domain.addition.Number;
import br.com.db1.passwordmeter.domain.addition.*;
import br.com.db1.passwordmeter.domain.deduction.*;
import br.com.db1.passwordmeter.domain.password.Password;
import com.google.common.collect.Lists;

import java.util.List;

public final class RequirementPassword implements Requirement {

    private List<Requirement> requirements;
    private final Password password;

    public RequirementPassword(Password password) {
        this.requirements = Lists.newArrayList(
            new NumberOfCharacters(password),
            new UppercaseLetters(password),
            new LowercaseLetters(password),
            new Number(password),
            new Symbol(password),
            new MiddleNumbersOrSymbols(password),
            new RequirementAddition(password),
            new LetterOnly(password),
            new NumberOnly(password),
            new RepeatCharacters(password),
            new ConsecutiveUppercaseLetters(password),
            new ConsecutiveLowercaseLetters(password),
            new ConsecutiveNumbers(password),
            new SequentialLettersThreePlus(password),
            new SequentialNumbersThreePlus(password),
            new SequentialSymbolsThreePlus(password)
        );
        this.password = password;
    }

    @Override
    public int getBonus() {
        return this.requirements.stream()
            .reduce(
                0,
                (subtotal, requirement) -> subtotal + (requirement.getBonus()),
                Integer::sum
            );
    }

    @Override
    public int getOccurrences() {
        return this.requirements.stream()
            .reduce(
                0,
                (subtotal, requirement) -> subtotal + (requirement.getOccurrences()),
                Integer::sum
            );
    }

    @Override
    public String getPasswordValue() {
        return this.password.value;
    }

    @Override
    public boolean isValid() {
        return true;
    }
}
