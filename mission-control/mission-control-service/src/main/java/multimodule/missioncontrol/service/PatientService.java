package multimodule.missioncontrol.service;

import multimodule.missioncontrol.model.Patient;

import java.util.Optional;
import java.util.UUID;

public interface PatientService {
    Patient create(Patient patient);
    Optional<Patient> getById(UUID id);
    void update(Patient patient);
    void deleteById(UUID id);
    Iterable<Patient> getAll();
}
