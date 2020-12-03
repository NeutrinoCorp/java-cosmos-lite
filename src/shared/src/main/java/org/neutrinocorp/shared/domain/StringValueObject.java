package org.neutrinocorp.shared.domain;

public abstract class StringValueObject {
    private String value;

    public StringValueObject(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
    
    @Override
    public String toString() {
        return this.value();
    }
}
