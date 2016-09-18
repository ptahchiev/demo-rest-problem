package com.example;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.Transient;
import java.util.Map;

/**
 * @author Petar Tahchiev
 * @since 1.2
 */
@Entity
public class ProductEntity {

    @Id
    private Long pk;

    @Transient
    private String test;

    @ElementCollection(targetClass = LobValue.class)
    @CollectionTable(name = "s_name_lv", joinColumns = @JoinColumn(name = "s_pk"))
    @MapKeyColumn(name = "locale")
    private Map<String, LobValue> s;

    public Long getPk() {
        return pk;
    }

    public void setPk(Long pk) {
        this.pk = pk;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public Map<String, LobValue> getS() {
        return s;
    }

    public void setS(Map<String, LobValue> s) {
        this.s = s;
    }
}
