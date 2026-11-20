package pl.wsb.inwentaryzacja.inventory.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import pl.wsb.inwentaryzacja.employee.entity.Employee;

import java.time.LocalDate;

@Entity
@Table(name = "inventory_check")
public class InventoryCheck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reference_number", nullable = false, unique = true, length = 30)
    private String referenceNumber;

    @Column(name = "scope", nullable = false, length = 100)
    private String scope;

    @Column(name = "checked_on", nullable = false)
    private LocalDate checkedOn;

    @Column(name = "checked_item_count", nullable = false)
    private int checkedItemCount;

    @Column(name = "discrepancy_count", nullable = false)
    private int discrepancyCount;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee checkedBy;

    protected InventoryCheck() {
    }

    public InventoryCheck(String referenceNumber, String scope, LocalDate checkedOn,
                          int checkedItemCount, int discrepancyCount, Employee checkedBy) {
        this.referenceNumber = referenceNumber;
        this.scope = scope;
        this.checkedOn = checkedOn;
        this.checkedItemCount = checkedItemCount;
        this.discrepancyCount = discrepancyCount;
        this.checkedBy = checkedBy;
    }

    public Long getId() {
        return id;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public String getScope() {
        return scope;
    }

    public LocalDate getCheckedOn() {
        return checkedOn;
    }

    public int getCheckedItemCount() {
        return checkedItemCount;
    }

    public int getDiscrepancyCount() {
        return discrepancyCount;
    }

    public Employee getCheckedBy() {
        return checkedBy;
    }
}
