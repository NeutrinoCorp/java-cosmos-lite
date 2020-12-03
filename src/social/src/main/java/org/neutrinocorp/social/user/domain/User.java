package org.neutrinocorp.social.user.domain;

import org.neutrinocorp.shared.domain.AggregateRoot;
import org.neutrinocorp.shared.domain.user.UserCreatedDomainEvent;
import org.neutrinocorp.shared.domain.user.UserRenamedDomainEvent;

public class User extends AggregateRoot {
    private final UserId id;
    private final Username username;
    private DisplayName displayName;

    public User(UserId id, Username username, DisplayName displayName) {
        this.id = id;
        this.username = username;
        this.displayName = displayName;
    }

    private User() {
        this.id = null;
        this.username = null;
        this.displayName = null;
    }

    public static User create(UserId id, Username username, DisplayName displayName) {
        User user = new User(id, username, displayName);
        user.record(new UserCreatedDomainEvent(user.id.value(), user.username.value(), user.displayName.value()));
        return user;
    }

    public void rename(DisplayName displayName) {
        this.displayName = displayName;
        record(new UserRenamedDomainEvent(id.value(), displayName.value()));
    }

    public UserId id() {
        return id;
    }

    public Username username() {
        return username;
    }

    public DisplayName displayName() {
        return displayName;
    }
}
