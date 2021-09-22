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
    private RatingDescription ratingDescription;

    @Valid
    @NotEmpty
    private List<RoleForm> roles = new ArrayList<>();

    //metod za setiranje na opis za rating
    public void setRatingDescription(RatingDescription ratingDescription) {
        this.ratingDescription = ratingDescription;
    }

    //metod za setiranje na lista od ulogi
    public void setRoles(List<RoleForm> asList) {
        this.roles = null;
    }

    public Iterable<Role> getItems() {
        return null;
    }

    public RatingDescription getRatingDescription() {
        return ratingDescription;
    }

}

