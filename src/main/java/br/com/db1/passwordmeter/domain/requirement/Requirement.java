package br.com.db1.passwordmeter.domain.requirement;

public interface Requirement {

    int getBonus();

    int getOccurrences();

    String getPasswordValue();

    default int getPasswordLength() {
        return this.getPasswordValue()
            .length();
    }

    boolean isValid();
}
