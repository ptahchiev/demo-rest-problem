package com.example;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Petar Tahchiev
 * @since 1.2
 */
@Entity
public class ProductEntity {

    @Id
    private Long pk;

    public Long getPk() {
        return pk;
    }

    public void setPk(Long pk) {
        this.pk = pk;
    }
}
