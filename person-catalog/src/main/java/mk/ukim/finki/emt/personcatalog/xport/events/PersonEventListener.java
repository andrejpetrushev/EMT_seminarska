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
//@AllArgsConstructor
public class PersonEventListener {

    private final PersonService personService;

    //konstruktor so argumenti
    public PersonEventListener(PersonService personService) {
        this.personService = personService;
    }

    //anotacija za listener, koj pravi subscribe na topic, potochno so RoleCreated
    @KafkaListener(topics= TopicHolder.TOPIC_ROLE_CREATED, groupId = "personCatalog")
    public void consumeRoleCreatedEvent(String jsonMessage) {
        try {
            RoleCreated event = DomainEvent.fromJson(jsonMessage, RoleCreated.class);
            personService.roleCreated(PersonId.of(event.getPersonId()), event.getStatus());
        } catch (Exception e){

        }
    }

    //anotacija za listener, koj pravi isto taka subscribe na topic, vo ovoj sluchaj so RoleRemoved
    @KafkaListener(topics= TopicHolder.TOPIC_ROLE_REMOVED, groupId = "personCatalog")
    public void consumeRoleRemovedEvent(String jsonMessage) {
        try {
            RoleRemoved event = DomainEvent.fromJson(jsonMessage, RoleRemoved.class);
            personService.roleRemoved(PersonId.of(event.getPersonId()), event.getStatus());
        } catch (Exception e){

        }
    }
}
