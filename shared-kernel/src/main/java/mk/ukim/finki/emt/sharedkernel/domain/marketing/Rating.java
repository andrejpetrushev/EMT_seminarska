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

    //anotacija deka stanuva zbor za atribut od tip enum
    @Enumerated(value = EnumType.STRING)
    private final RatingDescription ratingDescription;

    //i kaj dvata atributi se postavuva final bidejkji se immutable
    private final double grade;

    //prazen konstruktor
    protected Rating(){
        this.grade = 0.0;
        this.ratingDescription = null;
    }

    //konstruktor so argumenti
    public Rating(@NonNull RatingDescription ratingDescription, @NonNull double grade){
        this.ratingDescription = ratingDescription;
        this.grade = grade;
    }

    //get metod koj vrakja ocenka
    public double getGrade() {
        return grade;
    }

    //static metod koj vrakja instanca od Rating
    public static Rating valueOf(RatingDescription ratingDescription, double grade){
        return new Rating(ratingDescription, grade);
    }

    //OPERACII ZA DODAVANJE, ODZEMANJE I MNOZHENJE NA OCENKI VO RAMKI NA VREDNOSNIOT OBJEKT RATING

    //metod za dodavanje na oceni za objekti od tip Rating i frlanje iskluchok dokolku se so razlichen opis
    public Rating add(Rating rating) {
        if (!ratingDescription.equals(rating.ratingDescription)) {
            throw new IllegalArgumentException("Cannot add two Rating objects with different ratingDescriptions");
        }
        return new Rating(ratingDescription,grade + rating.grade);
    }

    //metod za odzemanje na oceni za objekti od tip Rating i frlanje iskluchok dokolku se so razlichen opis
    public Rating subtract(Rating rating) {
        if (!ratingDescription.equals(rating.ratingDescription)) {
            throw new IllegalArgumentException("Cannot subtract two Rating objects with different ratingDescriptions");
        }
        return new Rating(ratingDescription,grade - rating.grade);
    }

    //metod za mnozhenje na ocena za daden objekt od tip Rating so daden broj
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

    //sporedba na ocenkite za dva objekti od tip Rating
    public String compareTo(Rating r1, Rating r2){
        if(r1.grade < r2.grade){
            return "Object r2 has better rating than r1";
        }
        else if(r1.grade > r2.grade){
            return "Object r1 has better rating than r2";
        }
        else return "Two Rating objects are equal";
    }
}
