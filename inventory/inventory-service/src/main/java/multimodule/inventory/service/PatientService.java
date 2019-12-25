package multimodule.inventory.service;

import multimodule.inventory.model.Patient;

import java.util.Optional;
import java.util.UUID;

public interface PatientService {
    Patient create(Patient patient);
    Optional<Patient> getById(UUID id);
    void update(Patient patient);
    void deleteById(UUID id);
    Iterable<Patient> getAll();
}
