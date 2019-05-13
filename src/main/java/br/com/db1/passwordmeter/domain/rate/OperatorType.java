package br.com.db1.passwordmeter.domain.rate;

public enum OperatorType {
    POSITIVE(1),
    NEGATIVE(-1);

    public final int value;

    OperatorType(int value) {
        this.value = value;
    }
}
