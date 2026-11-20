package pl.wsb.inwentaryzacja.inventory.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import pl.wsb.inwentaryzacja.equipment.entity.Equipment;

@Entity
@Table(name = "inventory_check_item", uniqueConstraints =
        @UniqueConstraint(name = "uk_check_item_equipment", columnNames = {"inventory_check_id", "equipment_id"}))
public class InventoryCheckItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "inventory_check_id", nullable = false)
    private InventoryCheck inventoryCheck;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "equipment_id", nullable = false)
    private Equipment equipment;

    @Enumerated(EnumType.STRING)
    @Column(name = "result", nullable = false, length = 20)
    private CheckResult result;

    @Column(name = "note", length = 180)
    private String note;

    protected InventoryCheckItem() {
    }

    InventoryCheckItem(InventoryCheck inventoryCheck, Equipment equipment, CheckResult result, String note) {
        this.inventoryCheck = inventoryCheck;
        this.equipment = equipment;
        this.result = result;
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public InventoryCheck getInventoryCheck() {
        return inventoryCheck;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public CheckResult getResult() {
        return result;
    }

    public String getNote() {
        return note;
    }
}
