package com.example;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;

/**
 * @author Petar Tahchiev
 * @since 1.2
 */
public class ProductResourceProcessor implements ResourceProcessor<Resource<ProductEntity>> {

    @Override
    public Resource<ProductEntity> process(Resource<ProductEntity> resource) {
        resource.getContent().setTest("test");
        return resource;
    }
}
