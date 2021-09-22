package mk.ukim.finki.emt.rolesstaffmanagement.service.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.rolesstaffmanagement.domain.exceptions.RoleIdNotExistException;
import mk.ukim.finki.emt.rolesstaffmanagement.domain.exceptions.StaffIdNotExistException;
import mk.ukim.finki.emt.rolesstaffmanagement.domain.model.RoleId;
import mk.ukim.finki.emt.rolesstaffmanagement.domain.model.Staff;
import mk.ukim.finki.emt.rolesstaffmanagement.domain.model.StaffId;
import mk.ukim.finki.emt.rolesstaffmanagement.domain.repository.StaffRepository;
import mk.ukim.finki.emt.rolesstaffmanagement.service.StaffService;
import mk.ukim.finki.emt.rolesstaffmanagement.service.forms.RoleForm;
import mk.ukim.finki.emt.rolesstaffmanagement.service.forms.StaffForm;

import mk.ukim.finki.emt.sharedkernel.domain.events.staff.RoleCreated;
import mk.ukim.finki.emt.sharedkernel.domain.events.staff.RoleRemoved;
import mk.ukim.finki.emt.sharedkernel.infra.DomainEventPublisher;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

//klasa koja pravi implementacija na StaffService
@Service
@Transactional
@AllArgsConstructor
public class StaffServiceImpl implements StaffService {

    private final StaffRepository staffRepository;
    private final DomainEventPublisher domainEventPublisher;
    private final Validator validator;

    //konstruktor so parametri
    public StaffServiceImpl(StaffRepository staffRepository, DomainEventPublisher domainEventPublisher, Validator validator) {
        this.staffRepository = staffRepository;
        this.domainEventPublisher = domainEventPublisher;
        this.validator = validator;
    }

    //metod za podreduvanje na ulogi
    @Override
    public StaffId placeRole(String position, StaffForm staffForm) {
        Objects.requireNonNull(staffForm,"staff must not be null.");
        var constraintViolations = validator.validate(staffForm);
        if (constraintViolations.size()>0) {
            throw new ConstraintViolationException("The staff form is not valid", constraintViolations);
        }
        var newStaff = staffRepository.saveAndFlush(toDomainObject(position,staffForm));
        newStaff.getRoleList().forEach(item->domainEventPublisher.publish(new RoleCreated(item.getPersonId().getId(),item.getStatus())));
        return newStaff.getId();
    }

    //metod koj vrakja lista od vraboteni
    @Override
    public List<Staff> findAll() {
        return staffRepository.findAll();
    }

    //metod koj vrakja vraboten so id
    @Override
    public Optional<Staff> findById(StaffId id) {
        return staffRepository.findById(id);
    }

    //metod za dodavanje na odredeno lice
    @Override
    public void addItem(StaffId staffId, RoleForm roleForm) throws StaffIdNotExistException {
        Staff staff = staffRepository.findById(staffId).orElseThrow(StaffIdNotExistException::new);
        staff.addItem(roleForm.getPerson(),roleForm.getStatus());
        staffRepository.saveAndFlush(staff);
        domainEventPublisher.publish(new RoleCreated(roleForm.getPerson().getId().getId(),roleForm.getStatus()));
    }

    //metod za brishenje na odredeno lice
    @Override
    public void deleteItem(StaffId staffId, RoleId roleId) throws StaffIdNotExistException, RoleIdNotExistException {
        Staff staff = staffRepository.findById(staffId).orElseThrow(StaffIdNotExistException::new);
        staff.removeItem(roleId);
        staffRepository.saveAndFlush(staff);
    }

    //metod koj pravo prefruvanje na objekt od tip Staff vo DomainObject
    private Staff toDomainObject(String position, StaffForm staffForm) {
        var staff = new Staff(position, staffForm.getRatingDescription());
        staffForm.getItems().forEach(item->staff.addItem(item.getPerson(),item.getStatus()));
        return staff;
    }
}
