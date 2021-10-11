package mk.ukim.finki.emt.personcatalog.services.form;

import lombok.Data;
import mk.ukim.finki.emt.personcatalog.domain.models.Person;
import mk.ukim.finki.emt.sharedkernel.domain.marketing.Rating;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Data
public class PersonForm {

    //validaciski anotacii za osnovnite informacii koi treba da se vnesat vo formata
    @Valid
    @NotEmpty
    private String personName;

    @Valid
    @NotEmpty
    private String personSurname;

    @Valid
    @NotEmpty
    private Integer personAge;

    @Valid
    @NotEmpty
    private int personPhoneNumber;

    @Valid
    @NotEmpty
    private String personAddress;

    private Rating rating;
    private int purchases;

    //get metod koj vrakja ime na liceto
    public String getPersonName() {
        return personName;
    }

    //get metod koj vrakja prezime na liceto
    public String getPersonSurname() {
        return personSurname;
    }

    //get metod koj vrakja godini na liceto
    public int getPersonAge() {
        return personAge;
    }

    //get metod koj vrakja telefonski broj na liceto
    public int getPersonPhoneNumber() {
        return personPhoneNumber;
    }

    //get metod koj vrakja adresa na liceto
    public String getPersonAddress() {
        return personAddress;
    }

    //get metod koj vrakja rating
    public Rating getRating() {
        return rating;
    }

    //get metod koj vrakja broj na purchases
    public int getPurchases() {
        return purchases;
    }
}
