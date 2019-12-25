package multimodule.monitoring.repository;

import multimodule.monitoring.model.Observation;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface ObservationRepository extends PagingAndSortingRepository<Observation, UUID> {
}
