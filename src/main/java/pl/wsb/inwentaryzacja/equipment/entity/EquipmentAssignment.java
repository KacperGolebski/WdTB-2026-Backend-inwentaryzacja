package pl.wsb.inwentaryzacja.equipment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.Check;
import pl.wsb.inwentaryzacja.employee.entity.Employee;

import java.time.LocalDate;

@Entity
@Table(name = "equipment_assignment")
@Check(constraints = "returned_on is null or returned_on >= assigned_on")
public class EquipmentAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "equipment_id", nullable = false)
    private Equipment equipment;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(name = "assigned_on", nullable = false)
    private LocalDate assignedOn;

    @Column(name = "returned_on")
    private LocalDate returnedOn;

    protected EquipmentAssignment() {
    }

    public EquipmentAssignment(Equipment equipment, Employee employee, LocalDate assignedOn) {
        this.equipment = equipment;
        this.employee = employee;
        this.assignedOn = assignedOn;
    }

    public Long getId() {
        return id;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public Employee getEmployee() {
        return employee;
    }

    public LocalDate getAssignedOn() {
        return assignedOn;
    }

    public LocalDate getReturnedOn() {
        return returnedOn;
    }
}
