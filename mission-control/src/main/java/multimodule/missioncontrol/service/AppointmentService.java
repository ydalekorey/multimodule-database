package multimodule.missioncontrol.service;

import multimodule.missioncontrol.model.Appointment;

import java.util.Optional;
import java.util.UUID;

public interface AppointmentService {
    Appointment create(Appointment appointment);
    Optional<Appointment> getById(UUID id);
    void update(Appointment appointment);
    void deleteById(UUID id);
    Iterable<Appointment> getAll();
}
