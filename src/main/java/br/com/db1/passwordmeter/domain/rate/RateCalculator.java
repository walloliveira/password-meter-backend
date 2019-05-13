package br.com.db1.passwordmeter.domain.rate;

import br.com.db1.passwordmeter.domain.requirement.Requirement;

public interface RateCalculator {

    int calculate(Requirement requirement);
}
