package mk.ukim.finki.emt.sharedkernel.infra;

import mk.ukim.finki.emt.sharedkernel.domain.events.DomainEvent;

//publisher na nastani, koj gi publikuva istite za da mozhat listeners soodvetno da slushaat
public interface DomainEventPublisher {
    void publish(DomainEvent event);
}

