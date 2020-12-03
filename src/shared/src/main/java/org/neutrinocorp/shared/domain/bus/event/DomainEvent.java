package org.neutrinocorp.shared.domain.bus.event;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.UUID;

public abstract class DomainEvent {
    private String aggregateId;
    private String eventId;
    private String publishTime;

    public DomainEvent(String aggregateId) {
        this.aggregateId = aggregateId;
        this.eventId = UUID.randomUUID().toString();
        this.publishTime = LocalDateTime.now(ZoneOffset.UTC).toString();
    }

    public DomainEvent(String aggregateId, String eventId, String publishTime) {
        this.aggregateId = aggregateId;
        this.eventId = eventId;
        this.publishTime = publishTime;
    }

    protected DomainEvent() {}

    public abstract String eventName();

    public abstract HashMap<String, Serializable> toPrimitives();

    public abstract DomainEvent fromPrimitives(
            String aggregateId,
            HashMap<String, Serializable> body,
            String eventId,
            String publishTime
    );

    public String aggregateId() {
        return aggregateId;
    }

    public String eventId() {
        return eventId;
    }

    public String publishTime() {
        return publishTime;
    }
}
