package multimodule.monitoring.service;

import multimodule.monitoring.model.Tablet;

import java.util.Optional;
import java.util.UUID;

public interface TabletService {
    Tablet create(Tablet tablet);
    Optional<Tablet> getById(UUID id);
    void update(Tablet tablet);
    void deleteById(UUID id);
    Iterable<Tablet> getAll();
}
