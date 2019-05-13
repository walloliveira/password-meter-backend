package br.com.db1.passwordmeter.api;

import br.com.db1.passwordmeter.domain.password.PasswordResult;

public class PasswordResource {

    private int percentage;
    private static int MAX_PERCENTAGE = 100;
    private Complexity complexity;

    private PasswordResource(PasswordResult passwordResult) {
        this.percentage = passwordResult.getRate();
        this.complexity = Complexity.calculate(passwordResult);
    }

    public static PasswordResource fromDomain(PasswordResult passwordResult) {
        return new PasswordResource(passwordResult);
    }

    public int getPercentage() {
        if (percentage > MAX_PERCENTAGE)
            return MAX_PERCENTAGE;
        return percentage;
    }

    public Complexity getComplexity() {
        return complexity;
    }
}
