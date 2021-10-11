package mk.ukim.finki.emt.rolesstaffmanagement.domain.valueobjects;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class PersonId extends DomainObjectId {

    //konstruktor bez argumenti
    public PersonId() {
        super(PersonId.randomId(PersonId.class).getId());
    }

    //konstruktor so argumenti
    public PersonId(String uuid) {
        super(uuid);
    }
}
