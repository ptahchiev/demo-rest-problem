package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
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

    @Override
    public void configureJacksonObjectMapper(ObjectMapper objectMapper) {
        Hibernate5Module module = new Hibernate5Module();
        module.enable(Hibernate5Module.Feature.FORCE_LAZY_LOADING);
        module.disable(Hibernate5Module.Feature.USE_TRANSIENT_ANNOTATION);
        objectMapper.registerModule(module);
    }
}
