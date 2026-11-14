package pl.wsb.inwentaryzacja.employee.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_number", nullable = false, unique = true, length = 30)
    private String employeeNumber;

    @Column(name = "full_name", nullable = false, length = 100)
    private String fullName;

    @Column(name = "work_email", nullable = false, unique = true, length = 120)
    private String workEmail;

    @Column(name = "department", nullable = false, length = 60)
    private String department;

    protected Employee() {
    }

    public Employee(String employeeNumber, String fullName, String workEmail, String department) {
        this.employeeNumber = employeeNumber;
        this.fullName = fullName;
        this.workEmail = workEmail;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public String getWorkEmail() {
        return workEmail;
    }

    public String getDepartment() {
        return department;
    }
}
