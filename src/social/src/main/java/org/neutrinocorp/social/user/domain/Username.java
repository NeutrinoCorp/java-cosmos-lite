package org.neutrinocorp.social.user.domain;

import org.neutrinocorp.shared.domain.StringValueObject;

public class Username extends StringValueObject {
    public Username(String value) {
        super(value.toLowerCase());
        ensureMinLength(value);
        ensureMaxLength(value);
    }

    public Username() {
        super("");
    }

    private static void ensureMinLength(String value) throws UsernameOutOfRange {
        if (value.length() < 2) {
            throw new UsernameOutOfRange(value);
        }
    }

    private static void ensureMaxLength(String value) throws UsernameOutOfRange {
        if (value.length() > 128) {
            throw new UsernameOutOfRange(value);
        }
    }
}
