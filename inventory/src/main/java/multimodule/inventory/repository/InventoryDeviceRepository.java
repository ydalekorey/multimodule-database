package multimodule.inventory.repository;

import multimodule.inventory.model.Device;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface InventoryDeviceRepository extends PagingAndSortingRepository<Device, UUID> {
}