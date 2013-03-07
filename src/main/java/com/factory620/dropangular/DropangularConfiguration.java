package com.factory620.dropangular;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;
import com.yammer.dropwizard.db.DatabaseConfiguration;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;

/**
 * User: johneo
 * Date: 3/6/13
 * Time: 9:58 PM
 */
public class DropangularConfiguration extends Configuration {

    @NotEmpty
    @JsonProperty
    private String property;

    @Valid
    @NotEmpty
    @JsonProperty
    private DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration();

    public String getProperty() {
        return property;
    }

    public DatabaseConfiguration getDatabaseConfiguration() {
        return databaseConfiguration;
    }
}
