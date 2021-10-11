package mk.ukim.finki.emt.rolesstaffmanagement.domain.model;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

//vo ovaa klasa se kreira id za objekt od tip Role
public class RoleId extends DomainObjectId {

    //konstruktor bez argumenti
    private RoleId() {
        super(RoleId.randomId(RoleId.class).getId());
    }

    //konstruktor so argumenti
    public RoleId(String uuid) {
        super(uuid);
    }
}
