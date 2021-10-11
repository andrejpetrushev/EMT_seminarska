package mk.ukim.finki.emt.personcatalog.xport.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.personcatalog.domain.models.Person;
import mk.ukim.finki.emt.personcatalog.services.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//klasata PersonResource e rest controller i upravuva so site rest povici
@RestController
@RequestMapping("/api/person")
//@AllArgsConstructor
public class PersonResource {

    private final PersonService personService;

    //konstruktor so argumenti
    public PersonResource(PersonService personService) {
        this.personService = personService;
    }

    //get metod koj gi vrakja site objekti od tip List<Person>
    @GetMapping
    public List<Person> getAll() {
        return personService.getAll();
    }
}
