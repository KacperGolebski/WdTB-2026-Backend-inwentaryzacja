package pl.wsb.inwentaryzacja.equipment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class EquipmentLocation {

    @Column(name = "building", length = 60)
    private String building;

    @Column(name = "room", length = 30)
    private String room;

    protected EquipmentLocation() {
    }

    public EquipmentLocation(String building, String room) {
        this.building = building;
        this.room = room;
    }

    public String getBuilding() {
        return building;
    }

    public String getRoom() {
        return room;
    }
}
