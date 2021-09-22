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
        this.person = null;
    }

    //metod koj postavuva status
    public void setStatus(int i) {
        this.status = 0;
    }

    //metod koj vrakja status
    public int getStatus() {
        return status;
    }

    public Person getPerson() {
        return null;
    }

}
