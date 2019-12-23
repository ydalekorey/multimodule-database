package multimodule.inventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity//(name = "inventoryDevice")
@Table(name = "device", schema = "inventory")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "device_model_id")
    private String deviceModelId;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "date_acquired")
    private ZonedDateTime dateAcquired;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDeviceModelId() {
        return deviceModelId;
    }

    public void setDeviceModelId(String deviceModelId) {
        this.deviceModelId = deviceModelId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public ZonedDateTime getDateAcquired() {
        return dateAcquired;
    }

    public void setDateAcquired(ZonedDateTime dateAcquired) {
        this.dateAcquired = dateAcquired;
    }
}
