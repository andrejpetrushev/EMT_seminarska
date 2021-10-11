package mk.ukim.finki.emt.sharedkernel.domain.base;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import org.springframework.lang.NonNull;

import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
@Embeddable                 //anotacija deka ovaa klasa kje se embedira/vgradi vo ramki na drugi klasi
@Getter
public class DomainObjectId implements Serializable {

    private String id;

    //konstruktor so argumenti
    @JsonCreator
    protected DomainObjectId(@NonNull String uuid) {
        this.id = Objects.requireNonNull(uuid, "uuid must not be null");
    }

    //prazen - default konstruktor
    public DomainObjectId(){

    }

    //set metod za postavuvanje na id
    public void setId(String id) {
        this.id = id;
    }

    //get metod koj vrakja id
    public String getId() {
        return id;
    }

    //static metod za kreiranje na randomId od soodvetna klasa
    @NonNull
    public static <ID extends DomainObjectId> ID randomId(@NonNull Class<ID> idClass) {
        Objects.requireNonNull(idClass, "idClass must not be null");
        try {
            return idClass.getConstructor(String.class).newInstance(UUID.randomUUID().toString());
        } catch (Exception ex) {
            throw new RuntimeException("Could not create new instance of " + idClass, ex);
        }
    }
}
