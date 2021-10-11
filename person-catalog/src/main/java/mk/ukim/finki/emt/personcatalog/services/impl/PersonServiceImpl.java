package mk.ukim.finki.emt.personcatalog.services.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.personcatalog.domain.exceptions.PersonNotFoundException;
import mk.ukim.finki.emt.personcatalog.domain.models.Person;
import mk.ukim.finki.emt.personcatalog.domain.models.PersonId;
import mk.ukim.finki.emt.personcatalog.domain.repository.PersonRepository;
import mk.ukim.finki.emt.personcatalog.services.PersonService;
import mk.ukim.finki.emt.personcatalog.services.form.PersonForm;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service                            //anotacija deka stanuva zbor za servis
@Transactional                      //anotacija deka se pravat transakcii vo ramki na klasata
//@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    //konstruktor so argument
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    //metod za pronaogjanje lice spored ID
    @Override
    public Person findById(PersonId id) {
        return personRepository.findById(id).orElseThrow(PersonNotFoundException::new);
    }

    //metod za dodavanje na lice
    @Override
    public Person addPerson(PersonForm form) {
        Person p = Person.build(form.getPersonName(),form.getPersonSurname(),form.getPersonAge(),form.getPersonPhoneNumber(),form.getPersonAddress(),form.getRating(),form.getPurchases());
        personRepository.save(p);
        return p;
    }

    //metod koj vrakja objekt od tip Person, otkako kje go zgolemi brojot na kupuvanja koi gi napravil
    @Override
    public Person roleCreated(PersonId personId, int status) {
        Person p = personRepository.findById(personId).orElseThrow(PersonNotFoundException::new);
        p.addPurchases(status);
        personRepository.saveAndFlush(p);
        return p;
    }

    //metod koj vrakja objekt od tip Person, otkako kje go namali brojot na kupuvanja koi gi napravil
    @Override
    public Person roleRemoved(PersonId personId, int status) {
        Person p = personRepository.findById(personId).orElseThrow(PersonNotFoundException::new);
        p.removePurchases(status);
        personRepository.saveAndFlush(p);
        return p;
    }

    //metod koj vrakja lista od site objekti od tip Person
    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }
}

