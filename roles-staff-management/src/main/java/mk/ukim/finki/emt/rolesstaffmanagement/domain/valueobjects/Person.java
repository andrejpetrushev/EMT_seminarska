package mk.ukim.finki.emt.rolesstaffmanagement.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
import mk.ukim.finki.emt.sharedkernel.domain.marketing.Rating;
import mk.ukim.finki.emt.sharedkernel.domain.marketing.RatingDescription;

@Getter
public class Person implements ValueObject {

    private final PersonId id;
    private final String name;
    private final Rating rating;
    private final int purchases;

    private Person(){
        this.id=PersonId.randomId(PersonId.class);
        this.name= "";
        this.rating = Rating.valueOf(RatingDescription.GOOD,0);
        this.purchases = 0;
    }

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

    public Rating getRating() {
        return rating;
    }

    public String getId() {

    }
}
