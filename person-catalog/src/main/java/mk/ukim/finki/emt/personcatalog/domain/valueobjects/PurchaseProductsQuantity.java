package mk.ukim.finki.emt.personcatalog.domain.valueobjects;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class PurchaseProductsQuantity implements ValueObject {

    private final int quantity;

    protected PurchaseProductsQuantity(){
        this.quantity = 0;
    }
}
