package multimodule.monitoring.service;

import multimodule.monitoring.model.Observation;

import java.util.Optional;
import java.util.UUID;

public interface ObservationService {
    Observation create(Observation observation);
    Optional<Observation> getById(UUID id);
    void update(Observation observation);
    void deleteById(UUID id);
    Iterable<Observation> getAll();
}
