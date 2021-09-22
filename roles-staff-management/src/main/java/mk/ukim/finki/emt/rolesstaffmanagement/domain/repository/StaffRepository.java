package mk.ukim.finki.emt.rolesstaffmanagement.domain.repository;

import mk.ukim.finki.emt.rolesstaffmanagement.domain.model.Staff;
import mk.ukim.finki.emt.rolesstaffmanagement.domain.model.StaffId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, StaffId> {

}
