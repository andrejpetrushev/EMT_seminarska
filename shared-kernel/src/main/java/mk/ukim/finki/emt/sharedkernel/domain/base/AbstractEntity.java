package mk.ukim.finki.emt.sharedkernel.domain.base;

import lombok.Getter;
import org.springframework.data.util.ProxyUtils;
import org.springframework.lang.NonNull;

import javax.persistence.EmbeddedId;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

//od klasata AbstractEntity nasleduvaat glavnite klasi vo proektot, odnosno entiteti, se anotira kako Super klasa
@MappedSuperclass
@Getter
public class AbstractEntity<ID extends DomainObjectId> {

    //anotacija so koja id-to se oznachuva kako kompoziten kluch
    @EmbeddedId
    private ID id;

    //default konstruktor
    protected AbstractEntity() {
    }

    //konstruktor so argumenti
    protected AbstractEntity(@NonNull AbstractEntity<ID> source) {
        Objects.requireNonNull(source, "source must not be null");
        this.id = source.id;
    }

    protected AbstractEntity(@NonNull ID id) {
        this.id = Objects.requireNonNull(id, "id must not be null");
    }

    //get metod koj vrakja id od tip ID
    public ID getId() {
        return id;
    }

    //metod za ednakvost na objekti
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !getClass().equals(ProxyUtils.getUserClass(obj))) {
            return false;
        }

        var other = (AbstractEntity<?>) obj;
        return id != null && id.equals(other.id);
    }

    //metod koj vrakja hash vrednost
    @Override
    public int hashCode() {
        return id == null ? super.hashCode() : id.hashCode();
    }

    //metod koj pechati vo String format
    @Override
    public String toString() {
        return String.format("%s[%s]", getClass().getSimpleName(), id);
    }
}
