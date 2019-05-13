package br.com.db1.passwordmeter.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

class VerifyPasswordDTO {

    @NotEmpty(message = "Password is required")
    @NotNull(message = "Password is required")
    @JsonProperty("password")
    public String value;
}
