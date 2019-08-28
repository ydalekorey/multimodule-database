package multimodule.monitoring.service;

import multimodule.monitoring.model.Device;
import multimodule.monitoring.repository.MonitoringDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    private MonitoringDeviceRepository monitoringDeviceRepository;

    @Override
    public Device create(Device device) {
        return monitoringDeviceRepository.save(device);
    }

    @Override
    public Optional<Device> getById(UUID deviceId) {
        return monitoringDeviceRepository.findById(deviceId);
    }

    @Override
    public void update(Device device) {
        monitoringDeviceRepository.save(device);
    }

    @Override
    public void deleteById(UUID deviceId) {
        monitoringDeviceRepository.deleteById(deviceId);
    }

    @Override
    public Iterable<Device> getAll() {
        return monitoringDeviceRepository.findAll();
    }
}
