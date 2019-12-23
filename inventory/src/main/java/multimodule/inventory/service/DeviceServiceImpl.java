package multimodule.inventory.service;

import multimodule.inventory.model.Device;
import multimodule.inventory.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    @Override
    public Device create(Device device) {
        return deviceRepository.save(device);
    }

    @Override
    public Optional<Device> getById(UUID deviceId) {
        return deviceRepository.findById(deviceId);
    }

    @Override
    public void update(Device device) {
        deviceRepository.save(device);
    }

    @Override
    public void deleteById(UUID deviceId) {
        deviceRepository.deleteById(deviceId);
    }

    @Override
    public Iterable<Device> getAll() {
        return deviceRepository.findAll();
    }
}
