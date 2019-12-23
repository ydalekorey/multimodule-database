package multimodule.monitoring.repository;

import multimodule.monitoring.model.Device;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository("monitoringDeviceRepository")
public interface DeviceRepository extends PagingAndSortingRepository<Device, UUID> {
    Optional<Device> findBySerialNumber(String serialNumber);
}