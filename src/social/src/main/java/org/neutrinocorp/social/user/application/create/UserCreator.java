package org.neutrinocorp.social.user.application.create;

import org.neutrinocorp.social.user.domain.*;

public class UserCreator {
    private final UserRepository repository;
    // private final EventBus eventBus;

    public UserCreator(UserRepository repository) {
        this.repository = repository;
        // this.eventBus = eventBus;
    }

    public void create(UserId id, Username username, DisplayName displayName) {
        User user = User.create(id, username, displayName);
        repository.save(user);
        // eventBus.publish(user.pullEvents());
    }
}
