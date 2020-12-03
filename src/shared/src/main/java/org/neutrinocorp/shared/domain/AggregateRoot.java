package org.neutrinocorp.shared.domain;

import org.neutrinocorp.shared.domain.bus.event.DomainEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AggregateRoot {
    protected List<DomainEvent> events = new ArrayList<>();

    final public List<DomainEvent> pullEvents() {
        List<DomainEvent> memoEvents = events;
        events = Collections.emptyList();
        return memoEvents;
    }

    final protected void record(DomainEvent event) {
        events.add(event);
    }
}
