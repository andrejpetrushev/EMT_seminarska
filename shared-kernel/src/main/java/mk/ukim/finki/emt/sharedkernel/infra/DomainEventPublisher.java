package mk.ukim.finki.emt.sharedkernel.infra;

import mk.ukim.finki.emt.sharedkernel.domain.events.DomainEvent;

//interfejs - publisher na nastani, so metod za publikuvanje na istite
public interface DomainEventPublisher {
    void publish(DomainEvent event);
}

