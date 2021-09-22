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

    //konstruktor so parametri za brishenje na uloga
    public RoleRemoved(String topic, String personId, int status) {
        super(TopicHolder.TOPIC_ROLE_REMOVED);
        this.personId = personId;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }


    public String getPersonId() {

    }
}
