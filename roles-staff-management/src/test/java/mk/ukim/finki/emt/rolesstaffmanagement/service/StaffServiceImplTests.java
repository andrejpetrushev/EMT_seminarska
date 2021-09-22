package mk.ukim.finki.emt.rolesstaffmanagement.service;

import mk.ukim.finki.emt.rolesstaffmanagement.domain.exceptions.StaffIdNotExistException;
import mk.ukim.finki.emt.rolesstaffmanagement.domain.model.Role;
import mk.ukim.finki.emt.rolesstaffmanagement.domain.model.Staff;
import mk.ukim.finki.emt.rolesstaffmanagement.domain.model.StaffId;
import mk.ukim.finki.emt.rolesstaffmanagement.domain.valueobjects.Person;
import mk.ukim.finki.emt.rolesstaffmanagement.domain.valueobjects.PersonId;
import mk.ukim.finki.emt.rolesstaffmanagement.service.forms.StaffForm;
import mk.ukim.finki.emt.rolesstaffmanagement.service.forms.RoleForm;
import mk.ukim.finki.emt.rolesstaffmanagement.xport.client.PersonClient;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.sharedkernel.domain.marketing.RatingDescription;
import mk.ukim.finki.emt.sharedkernel.domain.marketing.Rating;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class StaffServiceImplTests {

    @Autowired
    private StaffService staffService;

    @Autowired
    private PersonClient personClient;

    //static metod koj vrakja objekt od tip Person
    private static Person newPerson(String name, Rating rating) {
        Person p = new Person(PersonId.randomId(PersonId.class), name, rating, 0);
        return p;
    }

    //test za podreduvanje na ulogi
    @Test
    public void testPlaceRole() {

        RoleForm rf1 = new RoleForm();
        rf1.setPerson(newPerson("Andrej", Rating.valueOf(RatingDescription.EXCELLENT, 5)));
        rf1.setStatus(1);

        RoleForm rf2 = new RoleForm();
        rf2.setPerson(newPerson("Zorica", Rating.valueOf(RatingDescription.EXCELLENT, 10)));
        rf2.setStatus(2);

        StaffForm staffForm = new StaffForm();
        staffForm.setRatingDescription(RatingDescription.EXCELLENT);
        staffForm.setRoles(Arrays.asList(rf1,rf2));

        StaffId newStaffId = staffService.placeRole(position, staffForm);
        Staff newStaff = staffService.findById(newStaffId).orElseThrow(StaffIdNotExistException::new);
        Assertions.assertEquals(newStaff.number_suggestions(),Rating.valueOf(RatingDescription.EXCELLENT, 20));

    }

    //test za podreduvanje na ulogi so koristenje na realni podatoci
    @Test
    public void testPlaceRoleWithRealData() {
        List<Person> personList = personClient.findAll();
        Person p1 = personList.get(0);
        Person p2 = personList.get(1);

        RoleForm rf1 = new RoleForm();
        rf1.setPerson(p1);
        rf1.setStatus(1);

        RoleForm rf2 = new RoleForm();
        rf2.setPerson(p2);
        rf2.setStatus(2);

        StaffForm staffForm = new StaffForm();
        staffForm.setRatingDescription(RatingDescription.GOOD);
        staffForm.setRoles(Arrays.asList(rf1, rf2));

        StaffId newStaffId = staffService.placeRole(position,staffForm);
        Staff newStaff = staffService.findById(newStaffId).orElseThrow(StaffIdNotExistException::new);

        Rating outRating = p1.getRating().multiply(rf1.getStatus()).add(p2.getRating().multiply(rf2.getStatus()));
        Assertions.assertEquals(newStaff.number_suggestions(),outRating);
    }

}

