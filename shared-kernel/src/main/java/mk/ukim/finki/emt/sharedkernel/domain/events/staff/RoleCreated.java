package mk.ukim.finki.emt.sharedkernel.domain.events.staff;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.config.TopicHolder;
import mk.ukim.finki.emt.sharedkernel.domain.events.DomainEvent;

@Getter
public class RoleCreated extends DomainEvent {

    //dopolnitelni informacii koi se prakjaat
    private String personId;
    private int status;

    //se kreira topic na koj ima producer koj pravi publish na poraki i subscriberi koi gi slushaat istite poraki
    public RoleCreated(String topic) {
        super(TopicHolder.TOPIC_ROLE_CREATED);
    }

    //konstruktor so argumenti (id i status)
    public RoleCreated(String personId, int status) {
        super(TopicHolder.TOPIC_ROLE_CREATED);
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

