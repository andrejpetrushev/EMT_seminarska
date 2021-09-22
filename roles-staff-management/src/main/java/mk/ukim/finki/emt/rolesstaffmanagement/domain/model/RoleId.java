package mk.ukim.finki.emt.rolesstaffmanagement.domain.model;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class RoleId extends DomainObjectId {

    private RoleId() {
        super(RoleId.randomId(RoleId.class).getId());
    }

    private String getId() {

    }

    public RoleId(String uuid) {
        super(uuid);
    }
}
