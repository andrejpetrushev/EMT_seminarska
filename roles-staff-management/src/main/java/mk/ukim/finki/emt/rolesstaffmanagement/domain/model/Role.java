package mk.ukim.finki.emt.rolesstaffmanagement.domain.model;

import lombok.Getter;
import mk.ukim.finki.emt.rolesstaffmanagement.domain.valueobjects.Person;
import mk.ukim.finki.emt.rolesstaffmanagement.domain.valueobjects.PersonId;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.sharedkernel.domain.marketing.Rating;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "role")
@Getter
public class Role extends AbstractEntity<RoleId> {

    private Rating specialBonus;

    @Column(name = "sts", nullable = false)
    private int status;

    @AttributeOverride(name = "id", column = @Column(name = "person_id", nullable = false))
    private PersonId personId;

    @Enumerated(EnumType.STRING)
    private RoleState roleState;

    public Role(){
        super(DomainObjectId.randomId(RoleId.class));
    }

    //konstruktor so parametri
    public Role(@NonNull PersonId personId, @NonNull Rating specialBonus, int status, RoleState roleState) {
        super(DomainObjectId.randomId(RoleId.class));
        this.personId = personId;
        this.specialBonus = specialBonus;
        this.status = status;
        this.roleState = roleState;
    }

    public Role(String id, Rating rating, int status) {

    }

    //metod za presmetka na status po bonus za odreden korisnik
    public Rating sub_number_Suggestions(){
        return specialBonus.multiply(status);
    }

    public Person getPerson() {

    }

    //metod koj postavuva status
    public void setStatus(int status) {
        this.status = status;
    }

    //metod koj vrakja status
    public int getStatus() {
        return status;
    }


    public Person getPersonId() {

    }

    public Object getId() {

    }
}