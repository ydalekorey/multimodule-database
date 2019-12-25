package multimodule.careplanning.service;

import multimodule.careplanning.model.Patient;

import java.util.Optional;
import java.util.UUID;

public interface PatientService {
    Patient create(Patient device);
    Optional<Patient> getById(UUID id);
    void update(Patient patient);
    void deleteById(UUID id);
    Iterable<Patient> getAll();
}
