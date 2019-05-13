package br.com.db1.passwordmeter.api;

import br.com.db1.passwordmeter.domain.password.PasswordResult;

public enum Complexity {
    TOO_SHORT(0, 0),
    VERY_WEAK(1, 20),
    WEAK(20, 40),
    GOOD(40, 60),
    STRONG(60, 80),
    VERY_STRONG(80, Integer.MAX_VALUE);

    private final int min;
    private final int max;

    Complexity(
        int min,
        int max
    ) {
        this.min = min;
        this.max = max;
    }

    public static Complexity calculate(PasswordResult passwordResult) {
        for (Complexity value : Complexity.values()) {
            if (passwordResult.getRate() >= value.min && passwordResult.getRate() < value.max) {
                return value;
            }
        }
        return Complexity.TOO_SHORT;
    }
}
