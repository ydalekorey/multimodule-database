package multimodule.missioncontrol.repository;

import multimodule.missioncontrol.model.Tablet;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("missionControlTabletRepository")
public interface TabletRepository extends PagingAndSortingRepository<Tablet, UUID> {
}
