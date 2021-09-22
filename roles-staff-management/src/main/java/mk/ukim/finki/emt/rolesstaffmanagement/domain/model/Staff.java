package mk.ukim.finki.emt.rolesstaffmanagement.domain.model;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.rolesstaffmanagement.domain.valueobjects.Person;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.marketing.Rating;
import mk.ukim.finki.emt.sharedkernel.domain.marketing.RatingDescription;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "staff_users")
@Getter
public class Staff extends AbstractEntity<StaffId> {

    private String name;

    private String surname;

    private String position;

    //private Rating number_suggestions;

    @Column(name = "staff_ratingDescription")
    @Enumerated(EnumType.STRING)
    private RatingDescription ratingDescription;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Role> roleList = new HashSet<>();

    public Staff(){
        super(StaffId.randomId(StaffId.class));
    }

    //konstruktor so parametri
    public Staff(String position, mk.ukim.finki.emt.sharedkernel.domain.marketing.RatingDescription ratingDescription) {
        super(StaffId.randomId(StaffId.class));
        this.position = position;
        this.ratingDescription = ratingDescription;
    }

    //metod koj vrakja broj na preporaki
    public Rating number_suggestions(){
        return roleList.stream().map(Role::sub_number_Suggestions).reduce(new Rating(ratingDescription, 0), Rating::add);
    }

    //metod za dodavanje na uloga
    public Role addItem(@NonNull Person person, int status) {
        Objects.requireNonNull(person,"person must not be null");
        var item  = new Role(person.getId(),person.getRating(),status);
        roleList.add(item);
        return item;
    }

    //metod za brishenje na uloga
    public void removeItem(@NonNull RoleId roleId) {
        Objects.requireNonNull(roleId,"Role Item must not be null");
        roleList.removeIf(v->v.getId().equals(roleId));
    }

    public Iterable<Role> getRoleList() {

    }

    public StaffId getId() {

    }
}
