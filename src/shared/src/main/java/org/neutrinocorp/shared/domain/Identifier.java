package org.neutrinocorp.shared.domain;

import org.neutrinocorp.shared.domain.error.IdentifierOutOfRange;

import java.io.Serializable;

public abstract class Identifier implements Serializable {
    final protected String value;

    public Identifier(String value) {
        ensureMaxLength(value);
        this.value = value;
    }

    protected Identifier() {
        this.value = null;
    }

    private void ensureMaxLength(String value) throws IdentifierOutOfRange {
        if (value.length() > 128) {
            throw new IdentifierOutOfRange(value);
        }
    }

    public String value() {
        return value;
    }
}
