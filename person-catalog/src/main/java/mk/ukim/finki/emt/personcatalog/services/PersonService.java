package mk.ukim.finki.emt.personcatalog.services;

import mk.ukim.finki.emt.personcatalog.domain.models.Person;
import mk.ukim.finki.emt.personcatalog.domain.models.PersonId;
import mk.ukim.finki.emt.personcatalog.services.form.PersonForm;

import java.util.List;

public interface PersonService {

    //metod za pronaogjanje lice spored id
    Person findById(PersonId id);

    //metod za dodavanje na novo lice
    Person addPerson(PersonForm form);

    //metod za kreiranje na uloga
    Person roleCreated(PersonId personId, int status);

    //metod za brishenje na uloga
    Person roleRemoved(PersonId personId, int status);

    //metod koj vrakja lista od objekti od tip Person
    List<Person> getAll();

}
