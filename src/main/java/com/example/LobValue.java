package com.example;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;

/**
 * @author Petar Tahchiev
 * @since 1.2
 */
@Embeddable
@Access(AccessType.FIELD)
public class LobValue {

    private String s;

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
}
