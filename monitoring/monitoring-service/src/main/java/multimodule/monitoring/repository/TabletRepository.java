package multimodule.monitoring.repository;

import multimodule.monitoring.model.Tablet;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("monitoringTabletRepository")
public interface TabletRepository extends PagingAndSortingRepository<Tablet, UUID> {
}
