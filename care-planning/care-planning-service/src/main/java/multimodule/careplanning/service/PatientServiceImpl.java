package multimodule.careplanning.service;

import multimodule.careplanning.events.PatientCreatedEvent;
import multimodule.careplanning.events.PatientDeletedEvent;
import multimodule.careplanning.events.PatientUpdatedEvent;
import multimodule.careplanning.model.Patient;
import multimodule.careplanning.repository.PatientRepository;
import multimodule.common.events.EventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private EventBus eventBus;

    @Autowired
    private PatientRepository repository;

    @Override
    public Patient create(Patient patient) {
        repository.save(patient);
        PatientCreatedEvent patientCreatedEvent = PatientCreatedEvent.builder()
                .birthDate(patient.getBirthDate())
                .firstName(patient.getFirstName())
                .lastName(patient.getLastName())
                .phoneNumber(patient.getPhoneNumber())
                .id(patient.getId())
                .build();
        eventBus.post("careplanning", patientCreatedEvent);
        return patient;
    }

    @Override
    public Optional<Patient> getById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public void update(Patient patient) {
        repository.save(patient);
        PatientUpdatedEvent patientUpdatedEvent = PatientUpdatedEvent.builder()
                .birthDate(patient.getBirthDate())
                .firstName(patient.getFirstName())
                .lastName(patient.getLastName())
                .phoneNumber(patient.getPhoneNumber())
                .id(patient.getId())
                .build();
        eventBus.post("careplanning", patientUpdatedEvent);
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
        PatientDeletedEvent patientDeletedEvent = PatientDeletedEvent.builder()
                .id(id)
                .build();
        eventBus.post("careplanning", patientDeletedEvent);
    }

    @Override
    public Iterable<Patient> getAll() {
        return repository.findAll();
    }
}
