package mk.ukim.finki.emt.personcatalog.services.form;

import lombok.Data;
import mk.ukim.finki.emt.personcatalog.domain.models.Person;
import mk.ukim.finki.emt.sharedkernel.domain.marketing.Rating;

@Data
public class PersonForm {

    private String personName;
    private String personSurname;
    private Integer personAge;
    private Long personPhoneNumber;
    private String personAddress;
    private Rating rating;
    private int purchases;

    public String getPersonName() {

    }

    public String getPersonSurname() {

    }

    public int getPersonAge() {

    }

    public int getPersonPhoneNumber() {

    }

    public String getPersonAddress() {

    }

    public Rating getRating() {

    }

    public int getPurchases() {

    }
}
