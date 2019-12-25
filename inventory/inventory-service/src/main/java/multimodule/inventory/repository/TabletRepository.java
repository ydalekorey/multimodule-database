package multimodule.inventory.repository;

import multimodule.inventory.model.Tablet;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("inventoryTabletRepository")
public interface TabletRepository extends PagingAndSortingRepository<Tablet, UUID> {
}
