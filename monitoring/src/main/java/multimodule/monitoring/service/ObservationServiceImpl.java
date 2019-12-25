package multimodule.monitoring.service;

import multimodule.monitoring.model.Observation;
import multimodule.monitoring.repository.ObservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ObservationServiceImpl implements ObservationService {

    @Autowired
    private ObservationRepository repository;

    @Override
    public Observation create(Observation observation) {
        return repository.save(observation);
    }

    @Override
    public Optional<Observation> getById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public void update(Observation observation) {
        repository.save(observation);
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public Iterable<Observation> getAll() {
        return repository.findAll();
    }
}
