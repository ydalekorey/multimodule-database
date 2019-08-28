package multimodule.inventory.web.dto;

import io.swagger.annotations.ApiModel;
import multimodule.inventory.model.Device;

import java.time.ZonedDateTime;

@ApiModel("Inventory Device")
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
