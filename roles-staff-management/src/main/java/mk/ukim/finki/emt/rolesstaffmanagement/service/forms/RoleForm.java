package mk.ukim.finki.emt.rolesstaffmanagement.service.forms;

import lombok.Data;
import mk.ukim.finki.emt.rolesstaffmanagement.domain.valueobjects.Person;
import mk.ukim.finki.emt.sharedkernel.domain.marketing.Rating;
import mk.ukim.finki.emt.sharedkernel.domain.marketing.RatingDescription;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class RoleForm {

    @NotNull
    private Person person;

    @Min(1)
    private int status = 1;

    //metod za postavuvanje na objekt od tip Person
    public void setPerson(Person person) {
        this.person = person;
    }

    //metod koj postavuva status
    public void setStatus(int status) {
        this.status = status;
    }

    //get metod koj vrakja status
    public int getStatus() {
        return status;
    }

    //get metod koj vrakja objekt od tip Person
    public Person getPerson() {
        return person;
    }
}
