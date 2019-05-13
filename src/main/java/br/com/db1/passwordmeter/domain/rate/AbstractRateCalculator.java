package br.com.db1.passwordmeter.domain.rate;

abstract class AbstractRateCalculator implements RateCalculator {

    private final int factor;
    private final OperatorType operator;

    public AbstractRateCalculator(int factor) {
        this(factor, OperatorType.POSITIVE);
    }

    public AbstractRateCalculator(
        int factor,
        OperatorType operator
    ) {
        this.factor = factor;
        this.operator = operator;
    }

    public int getFactor() {
        return factor;
    }

    public int getOperatorValue() {
        return this.operator.value;
    }
}
