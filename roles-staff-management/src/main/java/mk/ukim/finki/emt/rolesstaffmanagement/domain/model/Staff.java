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

@Entity                             //anotacija deka stanuva zbor za entitet
@Table(name = "staff_users")        //vo ramki na ovaa tabela se perzistiraat site promeni vo vrska so entitetot Staff
@Getter
//klasata Staff e Aggregate Root vo ogranicheniot kontekst 2
public class Staff extends AbstractEntity<StaffId> {

    private String name;

    private String surname;

    private String position;

    @Column(name = "staff_ratingDescription")
    @Enumerated(EnumType.STRING)
    private RatingDescription ratingDescription;

    //so ovaa anotacija se oznachuva vrskata pomegju dvata entiteti Staff i Role, potochno tipot na kardinalnosta
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Role> roleList = new HashSet<>();

    //konstruktor bez argumenti
    public Staff(){
        super(StaffId.randomId(StaffId.class));
    }

    public Staff(RatingDescription ratingDescription) {
        super(StaffId.randomId(StaffId.class));
        this.ratingDescription = ratingDescription;
    }

    //metod koj vrakja lista na preporaki, potochno suma od site preporaki, implementira biznis pravilo
    public Rating number_suggestions(){
        return roleList.stream().map(Role::sub_number_Suggestions).reduce(new Rating(ratingDescription, 0), Rating::add);
    }

    //metod za dodavanje na uloga
    public Role addRole(@NonNull Person person, int status) {
        Objects.requireNonNull(person,"person must not be null");                  //proverka dali objektot ne e null
        var item  = new Role(person.getId(),person.getRating(),status,RoleState.CUSTOMER);  //instanca od tip Role
        roleList.add(item);
        return item;
    }

    //metod za brishenje na uloga
    public void removeRole(@NonNull RoleId roleId) {
        Objects.requireNonNull(roleId,"Role Item must not be null");
        roleList.removeIf(v->v.getId().equals(roleId));
    }

    //get metod koj vrakja lista od ulogi
    public Set<Role> getRoleList() {
        return roleList;
    }

}
