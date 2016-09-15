package com.example;

import com.example.DemoRepositoryRestConfigurerAdapter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.support.Repositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.Resource;

/**
 * @author Petar Tahchiev
 * @since 1.2
 */
@EnableWebMvc
@EnableJpaRepositories(basePackages = { "com.example" })
@Configuration
public class DemoMvcConfiguration extends RepositoryRestMvcConfiguration {

    @Resource
    private WebApplicationContext context;

    @Autowired
    private Repositories repositories;

    @Bean(name = { "defaultRepositoryRestConfigurer" })
    public RepositoryRestConfigurer defaultRepositoryRestConfigurer() {
        return new DemoRepositoryRestConfigurerAdapter();
    }

    @Primary
    @Bean(name = "objectMapper")
    public ObjectMapper defaultObjectMapper() {
        return new ObjectMapper();
    }
}
