package multimodule.missioncontrol.service;

import multimodule.missioncontrol.model.Appointment;
import multimodule.missioncontrol.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository repository;

    @Override
    public Appointment create(Appointment appointment) {
        return repository.save(appointment);
    }

    @Override
    public Optional<Appointment> getById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public void update(Appointment appointment) {
        repository.save(appointment);
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public Iterable<Appointment> getAll() {
        return repository.findAll();
    }
}
