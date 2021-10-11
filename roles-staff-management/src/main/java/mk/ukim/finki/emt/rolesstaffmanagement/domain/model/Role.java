package mk.ukim.finki.emt.rolesstaffmanagement.domain.model;

import lombok.Getter;
import mk.ukim.finki.emt.rolesstaffmanagement.domain.valueobjects.Person;
import mk.ukim.finki.emt.rolesstaffmanagement.domain.valueobjects.PersonId;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.sharedkernel.domain.marketing.Rating;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity                         //anotacija deka stanuva zbor za entitet
@Table(name = "role")           //vo ramki na ovaa tabela se perzistiraat site promeni vo vrska so entitetot Role
@Getter
//entitet vo ogranicheniot kontekst 2
public class Role extends AbstractEntity<RoleId> {

    //promenliva od tip Rating - klasa koja e vo spodelenoto jadro
    private Rating specialBonus;

    @Column(name = "sts", nullable = false)
    private int status;

    //kreiranje na novo ime za id atributot za da se izbegne konflikt vo tabelata koja se generira
    @AttributeOverride(name = "id", column = @Column(name = "person_id", nullable = false))
    private PersonId personId;

    @Enumerated(EnumType.STRING)
    private RoleState roleState;

    //default konstruktor
    public Role(){
        super(DomainObjectId.randomId(RoleId.class));
    }

    //konstruktor so argumenti
    public Role(@NonNull PersonId personId, @NonNull Rating specialBonus, int status, RoleState roleState) {
        super(DomainObjectId.randomId(RoleId.class));
        this.personId = personId;
        this.specialBonus = specialBonus;
        this.status = status;
        this.roleState = roleState;
    }

    //metod za presmetka na status po bonus za odreden korisnik
    public Rating sub_number_Suggestions(){
        return specialBonus.multiply(status);
    }

    //metod koj postavuva status
    public void setStatus(int status) {
        this.status = status;
    }

    //get metod koj vrakja status
    public int getStatus() {
        return status;
    }

    //get metod koj vrakja id na objekt od tip Person
    public PersonId getPersonId() {
        return personId;
    }

    //get metod koj vrakja tekovna uloga na korisnik
    public RoleState getRoleState() {
        return roleState;
    }
}
