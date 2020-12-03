package org.neutrinocorp.social.user.domain;

import org.neutrinocorp.shared.domain.DomainError;

public class UsernameOutOfRange extends DomainError {
    public UsernameOutOfRange(String value) {
        super("username_out_of_range", String.format("username %s is out of range [2, 128)", value));
    }
}
