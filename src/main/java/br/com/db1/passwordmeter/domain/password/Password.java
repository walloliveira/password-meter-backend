package br.com.db1.passwordmeter.domain.password;

public final class Password {

    public final String value;

    private Password(String value) {
        this.value = (value == null ? "" : value);
    }

    public static Password of(String value) {
        return new Password(value);
    }
}
