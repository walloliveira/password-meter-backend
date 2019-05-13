package br.com.db1.passwordmeter.domain.password;

import br.com.db1.passwordmeter.domain.requirement.Requirement;
import br.com.db1.passwordmeter.domain.requirement.RequirementPassword;

public final class PasswordResult {

    private final int rate;

    private PasswordResult(PasswordResultBuilder builder) {
        this.rate = builder.requirement.getBonus();
    }

    public int getRate() {
        return rate;
    }

    public static PasswordResultBuilder builder() {
        return new PasswordResultBuilder();
    }

    public static class PasswordResultBuilder {

        private Password password;
        private Requirement requirement;

        private PasswordResultBuilder() {
        }

        public PasswordResult build() {
            withRequirement(new RequirementPassword(this.password));
            return new PasswordResult(this);
        }

        private PasswordResultBuilder withRequirement(RequirementPassword requirementPassword) {
            this.requirement = requirementPassword;
            return this;
        }

        public PasswordResultBuilder withPasswordRequest(Password password) {
            this.password = password;
            return this;
        }
    }
}
