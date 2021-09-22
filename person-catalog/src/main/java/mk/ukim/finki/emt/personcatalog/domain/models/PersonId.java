package mk.ukim.finki.emt.personcatalog.domain.models;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import org.springframework.lang.NonNull;

public class PersonId extends DomainObjectId {

    private PersonId() {
        super(PersonId.randomId(PersonId.class).getId());
    }

    private String getId() {

    }

    public PersonId(@NonNull String uuid) {
        super(uuid);
    }

    public static PersonId of(String uuid) {
        PersonId p = new PersonId(uuid);
        return p;
    }

}
