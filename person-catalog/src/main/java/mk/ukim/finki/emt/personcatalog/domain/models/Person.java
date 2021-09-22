package mk.ukim.finki.emt.personcatalog.domain.models;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import lombok.Getter;
import mk.ukim.finki.emt.personcatalog.domain.valueobjects.PurchaseProductsQuantity;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.marketing.Rating;

import javax.persistence.*;

@Entity
@Table(name = "people")
@Getter
public class Person extends AbstractEntity<PersonId> {

    private int purchases = 0;
    //private PurchaseProductsQuantity quantity;

    private String personName;

    private String personSurname;

    private Integer personAge;

    private int personPhoneNumber;

    private String personAddress;

    @AttributeOverrides({
            @AttributeOverride(name="grade", column = @Column(name="rating_grade")),
            @AttributeOverride(name="ratingdescription", column = @Column(name="rating_description"))
    })
    private Rating rating;

    private Person() {
        super(PersonId.randomId(PersonId.class));
    }

    public static Person build(String personName, String personSurname, Integer personAge, int personPhoneNumber, String personAddress, Rating rating, int purchases) {
        Person p = new Person();
        p.rating = rating;
        p.personName = personName;
        p.personSurname = personSurname;
        p.personAge = personAge;
        p.personPhoneNumber = personPhoneNumber;
        p.personAddress = personAddress;
        p.purchases = purchases;
        return p;
    }

    public void addPurchases(int qty) {
        this.purchases = this.purchases - qty;
    }

    public void removePurchases(int qty) {
        this.purchases -= qty;
    }


}
