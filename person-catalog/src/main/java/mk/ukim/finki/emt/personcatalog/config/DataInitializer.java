package mk.ukim.finki.emt.personcatalog.config;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.personcatalog.domain.models.Person;
import mk.ukim.finki.emt.personcatalog.domain.repository.PersonRepository;
import mk.ukim.finki.emt.sharedkernel.domain.marketing.RatingDescription;
import mk.ukim.finki.emt.sharedkernel.domain.marketing.Rating;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
//@AllArgsConstructor
public class DataInitializer {

    private final PersonRepository personRepository;

    //konstruktor so argumenti
    public DataInitializer(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    //metod za inicijaliziranje na podatoci za objekti od tip Person i dodavanje na istite vo baza
    @PostConstruct
    public void initData() {
        Person p1 = Person.build("Andrej", "Petrushev", 22, 072123456, "Skopje", Rating.valueOf(RatingDescription.EXCELLENT,10), 30);
        Person p2 = Person.build("Zorica", "Koceva", 22, 072321654, "Radovish", Rating.valueOf(RatingDescription.GOOD,5), 20);
        if (personRepository.findAll().isEmpty()) {
            personRepository.saveAll(Arrays.asList(p1,p2));
        }
    }
}
