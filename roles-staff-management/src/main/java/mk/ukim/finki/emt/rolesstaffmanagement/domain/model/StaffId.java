package mk.ukim.finki.emt.rolesstaffmanagement.domain.model;

import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class StaffId extends DomainObjectId {

    //konstruktor bez argumenti
    private StaffId() {
        super(StaffId.randomId(StaffId.class).getId());
    }

    //konstruktor so argumenti
    public StaffId(@NonNull String uuid) {
        super(uuid);
    }
}
