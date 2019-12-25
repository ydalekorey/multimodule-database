package multimodule.missioncontrol.repository;

import multimodule.missioncontrol.model.Appointment;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface AppointmentRepository extends PagingAndSortingRepository<Appointment, UUID> {
}
