package pl.wsb.inwentaryzacja.equipment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "equipment")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "inventory_number", nullable = false, unique = true, length = 30)
    private String inventoryNumber;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "serial_number", nullable = false, unique = true, length = 60)
    private String serialNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private EquipmentStatus status;

    @Embedded
    private EquipmentLocation location;

    protected Equipment() {
    }

    public Equipment(String inventoryNumber, String name, String serialNumber,
                     EquipmentStatus status, EquipmentLocation location) {
        this.inventoryNumber = inventoryNumber;
        this.name = name;
        this.serialNumber = serialNumber;
        this.status = status;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public String getInventoryNumber() {
        return inventoryNumber;
    }

    public String getName() {
        return name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public EquipmentStatus getStatus() {
        return status;
    }

    public EquipmentLocation getLocation() {
        return location;
    }
}
