package mk.ukim.finki.emt.personcatalog.domain.models;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import lombok.Getter;
import mk.ukim.finki.emt.personcatalog.domain.valueobjects.PurchaseProductsQuantity;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.marketing.Rating;

import javax.persistence.*;

@Entity                     //anotacija deka stanuva zbor za entitet
@Table(name = "people")     //vo ramki na ovaa tabela se perzistiraat site promeni vo vrska so entitetot Person
@Getter
//klasata Person e Aggregate Root vo ogranicheniot kontekst 1
//glaven i edinstven entitet vo person-catalog modulot
public class Person extends AbstractEntity<PersonId> {

    private int purchases = 0;

    private String personName;

    private String personSurname;

    private Integer personAge;

    private int personPhoneNumber;

    private String personAddress;

    //anotacija so koja se ovozmozhuva promena na iminjata na kolonite vo tabelata za soodvetnite promenlivi
    @AttributeOverrides({
            @AttributeOverride(name="grade", column = @Column(name="rating_grade")),
            @AttributeOverride(name="ratingdescription", column = @Column(name="rating_description"))
    })
    private Rating rating;

    //konstruktor bez argumenti
    public Person() {
        super(PersonId.randomId(PersonId.class));
    }

    //static metod build za kreiranje na objekt od tip Person so site potrebni argumenti
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

    //metod za dodavanje na status na brojot na purchases
    public void addPurchases(int sts) {
        this.purchases = this.purchases + sts;
    }

    //metod za brishenje na status na brojot na purchases
    public void removePurchases(int sts) {
        this.purchases -= sts;
    }

    //get metod koj vrakja broj na purchases
    public int getPurchases() {
        return purchases;
    }

    //metod koj postavuva broj na purchases
    public void setPurchases(int purchases) {
        this.purchases = purchases;
    }
}
