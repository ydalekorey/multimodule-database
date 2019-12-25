package multimodule.missioncontrol.repository;

import multimodule.missioncontrol.model.Patient;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("missionControlPatientRepository")
public interface PatientRepository extends PagingAndSortingRepository<Patient, UUID> {
}
