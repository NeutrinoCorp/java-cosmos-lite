package org.neutrinocorp.shared.domain.user;

import org.neutrinocorp.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;

public class UserRenamedDomainEvent extends DomainEvent {
    private final String displayName;

    public UserRenamedDomainEvent() {
        super(null);
        this.displayName = null;
    }

    public UserRenamedDomainEvent(String aggregateId, String displayName) {
        super(aggregateId);
        this.displayName = displayName;
    }

    public UserRenamedDomainEvent(String aggregateId, String eventId, String publishTime, String displayName) {
        super(aggregateId, eventId, publishTime);
        this.displayName = displayName;
    }

    @Override
    public String eventName() {
        return "user.renamed";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("display_name", displayName);
        }};
    }

    @Override
    public UserRenamedDomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String publishTime) {
        return new UserRenamedDomainEvent(aggregateId, eventId, publishTime, (String) body.get("display_name"));
    }
}
