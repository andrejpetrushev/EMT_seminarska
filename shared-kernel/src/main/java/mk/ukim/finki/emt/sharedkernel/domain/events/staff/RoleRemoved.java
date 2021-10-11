package mk.ukim.finki.emt.sharedkernel.domain.events.staff;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.config.TopicHolder;
import mk.ukim.finki.emt.sharedkernel.domain.events.DomainEvent;

@Getter
public class RoleRemoved extends DomainEvent {

    private String personId;
    private int status;

    public RoleRemoved(String topic) {
        super(TopicHolder.TOPIC_ROLE_REMOVED);
    }

    //konstruktor so argumenti (topic, id i status)
    public RoleRemoved(String topic, String personId, int status) {
        super(TopicHolder.TOPIC_ROLE_REMOVED);
        this.personId = personId;
        this.status = status;
    }

    //get metod koj vrakja status
    public int getStatus() {
        return status;
    }

    //get metod koj vrakja personId
    public String getPersonId() {
        return personId;
    }
}
