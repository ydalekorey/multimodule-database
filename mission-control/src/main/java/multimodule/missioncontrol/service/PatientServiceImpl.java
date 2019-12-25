package multimodule.missioncontrol.service;

import multimodule.missioncontrol.model.Patient;
import multimodule.missioncontrol.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository repository;

    @Override
    public Patient create(Patient patient) {
        return repository.save(patient);
    }

    @Override
    public Optional<Patient> getById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public void update(Patient patient) {
        repository.save(patient);
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public Iterable<Patient> getAll() {
        return repository.findAll();
    }
}
