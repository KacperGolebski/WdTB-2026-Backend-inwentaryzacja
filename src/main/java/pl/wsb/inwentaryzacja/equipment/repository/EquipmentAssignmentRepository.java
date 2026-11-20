package pl.wsb.inwentaryzacja.equipment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsb.inwentaryzacja.equipment.entity.EquipmentAssignment;

import java.util.List;

public interface EquipmentAssignmentRepository extends JpaRepository<EquipmentAssignment, Long> {

    List<EquipmentAssignment> findByEmployee_EmployeeNumberAndReturnedOnIsNull(String employeeNumber);
}
