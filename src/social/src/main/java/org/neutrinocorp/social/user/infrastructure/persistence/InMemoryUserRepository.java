package org.neutrinocorp.social.user.infrastructure.persistence;

import org.neutrinocorp.social.user.domain.User;
import org.neutrinocorp.social.user.domain.UserId;
import org.neutrinocorp.social.user.domain.UserRepository;

import java.util.HashMap;

public class InMemoryUserRepository implements UserRepository {
    private final HashMap<String, User> db = new HashMap<>();

    public InMemoryUserRepository() { }

    @Override
    public void save(User user) {
        db.put(user.id().value(), user);
    }

    @Override
    public User search(UserId id) {
        return db.get(id.value());
    }
}
