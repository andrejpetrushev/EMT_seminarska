package mk.ukim.finki.emt.rolesstaffmanagement.service.forms;

import lombok.Data;
import mk.ukim.finki.emt.rolesstaffmanagement.domain.model.Role;
import mk.ukim.finki.emt.sharedkernel.domain.marketing.RatingDescription;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
public class StaffForm {

    @NotNull
    private RatingDescription ratingDescription;            //opis na rating

    @Valid
    @NotEmpty
    private List<RoleForm> roles = new ArrayList<>();       //lista od ulogi koi korisnikot gi dodava

    //metod za setiranje na opis za rating
    public void setRatingDescription(RatingDescription ratingDescription) {
        this.ratingDescription = ratingDescription;
    }

    //metod za setiranje na lista od ulogi
    public void setRoles(List<RoleForm> roles) {
        this.roles = roles;
    }

    //get metod koj vrakja lista od ulogi
    public List<RoleForm> getRoles() {
        return roles;
    }

    //get metod koj vrakja opis na rating
    public RatingDescription getRatingDescription() {
        return ratingDescription;
    }

}

