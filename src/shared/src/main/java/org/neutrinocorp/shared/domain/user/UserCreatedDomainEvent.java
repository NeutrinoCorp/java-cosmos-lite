package org.neutrinocorp.shared.domain.user;

import org.neutrinocorp.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;

public class UserCreatedDomainEvent extends DomainEvent {
    private final String username;
    private final String displayName;

    public UserCreatedDomainEvent() {
        super(null);
        this.username = null;
        this.displayName = null;
    }

    public UserCreatedDomainEvent(String aggregateId, String username, String displayName) {
        super(aggregateId);
        this.username = username;
        this.displayName = displayName;
    }

    public UserCreatedDomainEvent(String aggregateId, String eventId, String publishTime, String username,
                                  String displayName) {
        super(aggregateId, eventId, publishTime);
        this.username = username;
        this.displayName = displayName;
    }

    @Override
    public String eventName() {
        return "user.created";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("username", username);
            put("display_name", displayName);
        }};
    }

    @Override
    public UserCreatedDomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId,
                                                 String publishTime) {
        return new UserCreatedDomainEvent(aggregateId, eventId, publishTime, (String) body.get("username"),
                (String) body.get("display_name"));
    }

    public String username() {
        return username;
    }

    public String displayName() {
        return displayName;
    }
}
