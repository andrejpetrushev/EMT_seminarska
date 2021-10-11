package mk.ukim.finki.emt.personcatalog.domain.valueobjects;

import lombok.Getter;
import mk.ukim.finki.emt.personcatalog.domain.models.Person;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
import mk.ukim.finki.emt.sharedkernel.domain.marketing.Rating;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

//klasa koja e vrednosen objekt, odnosno implementira odredeno biznis pravilo
@Embeddable
@Getter
public class PurchaseProductsQuantity implements ValueObject {

    //pole oznacheno so final, bidejkji e immutable (ne smee da se menuva)
    private final int quantity;

    private int totalQuantity;

    //konstruktor bez argumenti
    protected PurchaseProductsQuantity(){
        this.quantity = 0;
        this.totalQuantity = 0;
    }

    //metod vo koj se pravi promena na totalQuantity koga kje se promeni i brojot na purchases
    public int changeQuantity(Person p){
       totalQuantity += p.getPurchases();
       return totalQuantity;
    }
}
