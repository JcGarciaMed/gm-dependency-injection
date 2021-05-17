package com.greymatter.gmdependencyinjection.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties("gm")
public class GmConstructorConfig {

    private final String username;
    private final String password;
    private final String jdbcUrl;

    public GmConstructorConfig(String username, String password, String jdbcUrl) {
        this.username = username;
        this.password = password;
        this.jdbcUrl = jdbcUrl;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }
}
