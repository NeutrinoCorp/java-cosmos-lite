package org.neutrinocorp.social.user.domain;

import org.neutrinocorp.shared.domain.StringValueObject;

public class DisplayName extends StringValueObject {
    public DisplayName(String value) {
        super(value);
        ensureMinLength(value);
        ensureMaxLength(value);
    }

    public DisplayName() {
        super("");
    }

    private static void ensureMinLength(String value) throws DisplayNameOutOfRange {
        if (value.length() < 1) {
            throw new DisplayNameOutOfRange(value);
        }
    }

    private static void ensureMaxLength(String value) throws DisplayNameOutOfRange {
        if (value.length() > 256) {
            throw new DisplayNameOutOfRange(value);
        }
    }
}
