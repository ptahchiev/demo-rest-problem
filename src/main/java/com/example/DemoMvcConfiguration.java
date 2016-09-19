package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.support.Repositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

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

    @Resource
    private ProductRepository productRepository;

    @Autowired
    private Repositories repositories;

    //    @Bean(name = { "defaultRepositoryRestConfigurer" })
    //    public RepositoryRestConfigurer defaultRepositoryRestConfigurer() {
    //        return new DemoRepositoryRestConfigurerAdapter();
    //    }
    //
    @Primary
    @Bean(name = "objectMapper")
    public ObjectMapper defaultObjectMapper() {
        return new ObjectMapper();
    }

    @Bean(name = "productResourceProcessor")
    public ResourceProcessor<org.springframework.hateoas.Resource<ProductEntity>> mediaResourceProcessor() {
        return new ProductResourceProcessor();
    }

    @PostConstruct
    public void createProduct() {

        LobValue enLobValue = new LobValue();
        enLobValue.setS("english-blah");

        LobValue deLobValue = new LobValue();
        deLobValue.setS("german-blah");

        Map<String, LobValue> s = new HashMap<>();
        s.put("en", enLobValue);
        s.put("de", deLobValue);

        ProductEntity productEntity = new ProductEntity();
        productEntity.setPk(1L);
        productEntity.setS(s);

        productRepository.save(productEntity);
    }
}
