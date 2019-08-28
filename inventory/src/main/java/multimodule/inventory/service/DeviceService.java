package multimodule.inventory.service;

import multimodule.inventory.model.Device;

import java.util.Optional;
import java.util.UUID;

public interface DeviceService {
    Device create(Device device);
    Optional<Device> getById(UUID deviceId);
    void update(Device device);
    void deleteById(UUID deviceId);
    Iterable<Device> getAll();
}
