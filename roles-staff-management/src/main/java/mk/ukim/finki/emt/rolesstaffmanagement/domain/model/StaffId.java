package mk.ukim.finki.emt.rolesstaffmanagement.domain.model;

import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class StaffId extends DomainObjectId {

    private StaffId() {
        super(StaffId.randomId(StaffId.class).getId());
    }

    private String getId() {

    }

    public StaffId(@NonNull String uuid) {
        super(uuid);
    }
}
