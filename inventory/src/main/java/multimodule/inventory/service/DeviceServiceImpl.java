package multimodule.inventory.service;

import multimodule.inventory.model.Device;
import multimodule.inventory.repository.InventoryDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private InventoryDeviceRepository inventoryDeviceRepository;

    @Override
    public Device create(Device device) {
        return inventoryDeviceRepository.save(device);
    }

    @Override
    public Optional<Device> getById(UUID deviceId) {
        return inventoryDeviceRepository.findById(deviceId);
    }

    @Override
    public void update(Device device) {
        inventoryDeviceRepository.save(device);
    }

    @Override
    public void deleteById(UUID deviceId) {
        inventoryDeviceRepository.deleteById(deviceId);
    }

    @Override
    public Iterable<Device> getAll() {
        return inventoryDeviceRepository.findAll();
    }
}
