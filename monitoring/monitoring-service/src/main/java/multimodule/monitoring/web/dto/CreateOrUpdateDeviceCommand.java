package multimodule.monitoring.web.dto;

import io.swagger.annotations.ApiModel;
import multimodule.monitoring.model.Device;

@ApiModel("Monitoring device")
public class CreateOrUpdateDeviceCommand {

    private String accessToken;

    private String serialNumber;

    public Device toDevice() {
        Device device = new Device();
        device.setAccessToken(accessToken);
        device.setSerialNumber(serialNumber);
        return device;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
