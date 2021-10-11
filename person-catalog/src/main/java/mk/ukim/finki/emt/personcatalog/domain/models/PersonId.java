package mk.ukim.finki.emt.personcatalog.domain.models;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import org.springframework.lang.NonNull;

//preku ovaa klasa se kreira id za soodvetniot objekt od tip Person
public class PersonId extends DomainObjectId {

    //konstruktor bez argumenti
    private PersonId() {
        super(PersonId.randomId(PersonId.class).getId());
    }

    //konstruktor so argumenti
    public PersonId(@NonNull String uuid) {
        super(uuid);
    }

    //static builder metod
    public static PersonId of(String uuid) {
        PersonId p = new PersonId(uuid);
        return p;
    }
}
