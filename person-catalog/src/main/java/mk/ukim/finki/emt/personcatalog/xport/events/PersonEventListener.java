package mk.ukim.finki.emt.personcatalog.xport.events;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.personcatalog.domain.models.PersonId;
import mk.ukim.finki.emt.personcatalog.services.PersonService;
import mk.ukim.finki.emt.sharedkernel.domain.config.TopicHolder;
import mk.ukim.finki.emt.sharedkernel.domain.events.DomainEvent;
import mk.ukim.finki.emt.sharedkernel.domain.events.staff.RoleCreated;
import mk.ukim.finki.emt.sharedkernel.domain.events.staff.RoleRemoved;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonEventListener {

    private final PersonService personService;

    public PersonEventListener(PersonService personService) {
        this.personService = personService;
    }

    @KafkaListener(topics= TopicHolder.TOPIC_ROLE_CREATED, groupId = "personCatalog")
    public void consumeRoleCreatedEvent(String jsonMessage) {
        try {
            RoleCreated event = DomainEvent.fromJson(jsonMessage, RoleCreated.class);
            personService.roleCreated(PersonId.of(event.getPersonId()), event.getStatus());
        } catch (Exception e){

        }
    }

    @KafkaListener(topics= TopicHolder.TOPIC_ROLE_REMOVED, groupId = "personCatalog")
    public void consumeOrderItemRemovedEvent(String jsonMessage) {
        try {
            RoleRemoved event = DomainEvent.fromJson(jsonMessage, RoleRemoved.class);
            personService.roleRemoved(PersonId.of(event.getPersonId()), event.getStatus());
        } catch (Exception e){

        }

    }
}

