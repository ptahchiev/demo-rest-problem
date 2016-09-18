package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestProperties;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

/**
 * @author Petar Tahchiev
 * @since 1.2
 */
public class DemoRepositoryRestConfigurerAdapter extends RepositoryRestConfigurerAdapter {

    @Autowired
    private RepositoryRestProperties properties;

    @Override
    public void configureRepositoryRestConfiguration(final RepositoryRestConfiguration config) {
        this.properties.applyTo(config);
    }
}
