package com.imho.context;

import com.imho.config.ApplicationProperties;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ApplicationContext {
    private static ApplicationContext instance;
    private Connection connection;
    private ValidatorFactory validatorFactory;
    private Validator validator;

    private ApplicationContext() {
    }

    public static ApplicationContext getInstance() {
        if (instance == null) {
            instance = new ApplicationContext();
        }
        return instance;
    }

    public Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                        ApplicationProperties.URL,
                        ApplicationProperties.USERNAME,
                        ApplicationProperties.PASSWORD
                );
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }

    private ValidatorFactory getValidatorFactory() {
        if (validatorFactory == null) {
            validatorFactory = Validation.byDefaultProvider()
                    .configure()
                    .messageInterpolator(new ParameterMessageInterpolator())
                    .buildValidatorFactory();
        }
        return validatorFactory;
    }

    public Validator getValidator() {
        if (validator == null) {
            validator = getValidatorFactory().getValidator();
        }
        return validator;
    }

}
