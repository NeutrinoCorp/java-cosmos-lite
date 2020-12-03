package org.neutrinocorp.social.user.domain;

public interface UserRepository {
    void save(User user);
    User search(UserId id);
}
