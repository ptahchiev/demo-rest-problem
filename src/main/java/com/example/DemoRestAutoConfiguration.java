package com.example;

import com.DemoMvcConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.RepositoryRestDispatcherServlet;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.Servlet;

/**
 * @author Petar Tahchiev
 * @since 1.2
 */
@Configuration
@EnableConfigurationProperties(value = { RepositoryRestProperties.class })
public class DemoRestAutoConfiguration extends WebMvcConfigurerAdapter {

    public static final String REST_DISPATCHER_SERVLET_NAME = "repositoryRestDispatcherServlet";

    @Bean(name = { "defaultRepositoryRestDispatcherServlet", REST_DISPATCHER_SERVLET_NAME })
    @ConditionalOnMissingBean(name = REST_DISPATCHER_SERVLET_NAME)
    public ServletRegistrationBean defaultRepositoryRestDispatcherServlet(final RepositoryRestProperties repositoryRestProperties) {
        AnnotationConfigWebApplicationContext webCtx = new AnnotationConfigWebApplicationContext();
        webCtx.register(DemoMvcConfiguration.class);

        Servlet restDispatcherServlet = new RepositoryRestDispatcherServlet(webCtx);
        ServletRegistrationBean restDispatcherServletReg = new ServletRegistrationBean(restDispatcherServlet);
        restDispatcherServletReg.setName(REST_DISPATCHER_SERVLET_NAME);
        restDispatcherServletReg.setLoadOnStartup(1);
        restDispatcherServletReg.addUrlMappings(repositoryRestProperties.getBasePath() + "/*");

        return restDispatcherServletReg;
    }
}