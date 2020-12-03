package org.neutrinocorp.shared.domain.error;

import org.neutrinocorp.shared.domain.DomainError;

public final class IdentifierOutOfRange extends DomainError {
    public IdentifierOutOfRange(String value) {
        super("identifier_out_of_range", String.format("the identifier %s is out of range", value));
    }
}
