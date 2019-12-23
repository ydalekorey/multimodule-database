package multimodule.inventory.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity(name = "inventoryDevice")
@Table(name = "device", schema = "inventory")
@Getter
@Setter
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
}
