package mk.ukim.finki.emt.sharedkernel.domain.marketing;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Objects;

@Embeddable
@Getter
public class Rating implements ValueObject {

    @Enumerated(value = EnumType.STRING)
    private final RatingDescription ratingDescription;

    private final double grade;

    //prazen konstruktor
    protected Rating(){
        this.grade = 0.0;
        this.ratingDescription = null;
    }

    //konstruktor so parametri
    public Rating(@NonNull RatingDescription ratingDescription, @NonNull double grade){
        this.ratingDescription = ratingDescription;
        this.grade = grade;
    }

    //metod so koj se vrakja soodvetna vrednost za Rating
    public static Rating valueOf(RatingDescription ratingDescription, int grade){ return new Rating(ratingDescription, grade);}

    //metod za sobiranje na grades za Rating i iskluchok dokolku se so razlichen opis
    public Rating add(Rating rating) {
        if (!ratingDescription.equals(rating.ratingDescription)) {
            throw new IllegalArgumentException("Cannot add two Rating objects with different ratingDescriptions");
        }
        return new Rating(ratingDescription,grade + rating.grade);
    }

    //metod za odzemanje na grades za Rating i iskluchok dokolku se so razlichen opis
    public Rating subtract(Rating rating) {
        if (!ratingDescription.equals(rating.ratingDescription)) {
            throw new IllegalArgumentException("Cannot add two Rating objects with different ratingDescriptions");
        }
        return new Rating(ratingDescription,grade - rating.grade);
    }

    //metod za mnozhenje na grade so daden broj
    public Rating multiply(int m)  {
        return new Rating(ratingDescription,grade*m);
    }

    //metod koj proveruva dali se ednakvi dvata objekti
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating = (Rating) o;
        return grade == rating.grade && ratingDescription == rating.ratingDescription;
    }

    //metod koj vrakja hash vrednost
    @Override
    public int hashCode() {
        return Objects.hash(ratingDescription, grade);
    }
}
