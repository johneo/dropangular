package com.factory620.dropangular.core;

/**
 * User: johneo
 * Date: 3/6/13
 * Time: 10:08 PM
 */
public class Payload {
    private long id;
    private String aValue;

    public Payload() { /* JavaBeans */ }

    public Payload(long id, String aValue) {
        this.id = id;
        this.aValue = aValue;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getaValue() {
        return aValue;
    }

    public void setaValue(String aValue) {
        this.aValue = aValue;
    }
}
