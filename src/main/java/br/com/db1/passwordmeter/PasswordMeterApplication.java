package br.com.db1.passwordmeter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class PasswordMeterApplication {

    public static void main(String[] args) {
        SpringApplication.run(PasswordMeterApplication.class, args);
    }
}
