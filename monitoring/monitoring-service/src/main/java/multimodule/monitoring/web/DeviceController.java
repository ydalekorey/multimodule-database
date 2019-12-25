package multimodule.monitoring.web;

import multimodule.monitoring.model.Device;
import multimodule.monitoring.service.DeviceService;
import multimodule.monitoring.web.dto.CreateOrUpdateDeviceCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/monitoring/devices")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @GetMapping
    @ResponseBody
    public Iterable<Device> getDevices() {
        return deviceService.getAll();
    }

    @PostMapping
    @ResponseBody
    public Device create(@RequestBody CreateOrUpdateDeviceCommand device) {
        return deviceService.create(device.toDevice());
    }

    @GetMapping("/{deviceId}")
    public ResponseEntity<Device> getById(@PathVariable("deviceId") UUID deviceId) {
        return ResponseEntity.of(deviceService.getById(deviceId));
    }

    @PutMapping("/{deviceId}")
    public ResponseEntity update(@PathVariable("deviceId") UUID deviceId, @RequestBody CreateOrUpdateDeviceCommand deviceUpdate) {
        Device device = deviceUpdate.toDevice();
        device.setId(deviceId);
        deviceService.update(device);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity delete(UUID deviceId) {
        deviceService.deleteById(deviceId);
        return ResponseEntity.ok().build();
    }
}