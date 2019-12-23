package multimodule.monitoring.repository;

import multimodule.monitoring.model.Device;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;
import java.util.UUID;

public interface MonitoringDeviceRepository extends PagingAndSortingRepository<Device, UUID> {
    Optional<Device> findBySerialNumber(String serialNumber);
}