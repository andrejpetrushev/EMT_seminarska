package mk.ukim.finki.emt.rolesstaffmanagement.service;

import mk.ukim.finki.emt.rolesstaffmanagement.domain.exceptions.RoleIdNotExistException;
import mk.ukim.finki.emt.rolesstaffmanagement.domain.exceptions.StaffIdNotExistException;
import mk.ukim.finki.emt.rolesstaffmanagement.domain.model.RoleId;
import mk.ukim.finki.emt.rolesstaffmanagement.domain.model.Staff;
import mk.ukim.finki.emt.rolesstaffmanagement.domain.model.StaffId;
import mk.ukim.finki.emt.rolesstaffmanagement.service.forms.RoleForm;
import mk.ukim.finki.emt.rolesstaffmanagement.service.forms.StaffForm;
import org.springframework.boot.web.servlet.filter.OrderedFormContentFilter;

import java.util.List;
import java.util.Optional;

public interface StaffService {

    //metod za poreduvanje na ulogi
    StaffId placeRole(String position, StaffForm staffForm);

    //metod koj vrakja lista od vraboteni
    List<Staff> findAll();

    //metod koj vrakja vraboten so soodvetno id
    Optional<Staff> findById(StaffId id);

    //metod za dodavanje na item
    void addItem(StaffId staffId, RoleForm roleForm) throws StaffIdNotExistException;

    //metod za brishenje na item
    void deleteItem(StaffId staffId, RoleId roleId) throws StaffIdNotExistException, RoleIdNotExistException;
}
