package mk.ukim.finki.emt.rolesstaffmanagement.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.emt.rolesstaffmanagement.domain.model.Role;
import mk.ukim.finki.emt.rolesstaffmanagement.domain.model.RoleState;
import mk.ukim.finki.emt.rolesstaffmanagement.domain.model.Staff;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
import mk.ukim.finki.emt.sharedkernel.domain.marketing.Rating;
import mk.ukim.finki.emt.sharedkernel.domain.marketing.RatingDescription;

@Getter
public class Person implements ValueObject {

    private final PersonId id;
    private final String name;
    private final Rating rating;
    private final int purchases;

    //konstruktor bez argumenti
    private Person(){
        this.id=PersonId.randomId(PersonId.class);
        this.name= "";
        this.rating = Rating.valueOf(RatingDescription.GOOD,0);
        this.purchases = 0;
    }

    //konstruktor so argumenti, se koristi anotacija @JsonProperty za pri serijalizacija da se napravi tochno mapiranje vo soodveten atribut
    @JsonCreator
    public Person(@JsonProperty("id") PersonId id,
                   @JsonProperty("personName") String name,
                   @JsonProperty("rating") Rating rating,
                   @JsonProperty("purchases") int purchases) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.purchases = purchases;
    }

    //get metod koj vrakja rating
    public Rating getRating() {
        return rating;
    }

    //get metod koj vrakja id
    public PersonId getId() {
        return id;
    }

    //get metod koj vrakja broj na purchases
    public int getPurchases() {
        return purchases;
    }

    //metod koj vrakja broj na purchases zgolemen za 1 za onie korisnici koi dale ocenka za produkt pomegju 4 i 5 i koi imaat kupeno povekje od 3 produkti
    public int changeNumberOfPurchases(Rating r){
        int currentPurchases = 0;
        if(purchases >= 3){
            if(r.getGrade()>=4.0 && r.getGrade() <=5.0){
                 currentPurchases = this.getPurchases();
                 currentPurchases += 1;
            }
        }
        return currentPurchases;
    }
}
