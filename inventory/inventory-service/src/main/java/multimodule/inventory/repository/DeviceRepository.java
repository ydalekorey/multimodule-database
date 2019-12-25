package multimodule.inventory.repository;

import multimodule.inventory.model.Device;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository("inventoryDeviceRepository")
public interface DeviceRepository extends PagingAndSortingRepository<Device, UUID> {
    Optional<Device> findBySerialNumber(String serialNumber);
}
