package mk.ukim.finki.emt.personcatalog.domain.repository;

import mk.ukim.finki.emt.personcatalog.domain.models.Person;
import mk.ukim.finki.emt.personcatalog.domain.models.PersonId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, PersonId> {

}

