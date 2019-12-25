package multimodule.inventory.web.dto;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import multimodule.inventory.model.Device;

import java.time.ZonedDateTime;

@ApiModel("Inventory Device")
@Getter
@Setter
public class CreateOrUpdateDeviceCommand {

    private String deviceModelId;

    private String serialNumber;

    private ZonedDateTime dateAcquired;

    public Device toDevice() {
        Device device = new Device();
        device.setDateAcquired(dateAcquired);
        device.setDeviceModelId(deviceModelId);
        device.setSerialNumber(serialNumber);
        return device;
    }
}
