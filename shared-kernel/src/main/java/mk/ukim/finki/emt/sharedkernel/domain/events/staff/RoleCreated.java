package mk.ukim.finki.emt.sharedkernel.domain.events.staff;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.config.TopicHolder;
import mk.ukim.finki.emt.sharedkernel.domain.events.DomainEvent;

@Getter
public class RoleCreated extends DomainEvent {

    private String personId;
    private int status;

    //se kreira topic na koj shto soodvetno imame producer koj pravi publish na nekoi poraki i subscriberi koi gi slushaat istite poraki
    public RoleCreated(String topic) {
        super(TopicHolder.TOPIC_ROLE_CREATED);
    }

    //konstruktor so parametri za kreiranje na uloga
    public RoleCreated(String personId, int status) {
        super(TopicHolder.TOPIC_ROLE_CREATED);
        this.personId = personId;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public String getPersonId() {

    }
}

