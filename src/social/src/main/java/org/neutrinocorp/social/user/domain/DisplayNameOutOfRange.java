package org.neutrinocorp.social.user.domain;

import org.neutrinocorp.shared.domain.DomainError;

public class DisplayNameOutOfRange extends DomainError {
    public DisplayNameOutOfRange(String value) {
        super("display_name_out_of_range", String.format("display name %s is out of range [1, 256)", value));
    }
}
