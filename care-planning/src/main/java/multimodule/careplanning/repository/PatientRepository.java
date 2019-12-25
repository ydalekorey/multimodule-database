package multimodule.careplanning.repository;

import multimodule.careplanning.model.Patient;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("carePlanningPatientRepository")
public interface PatientRepository extends PagingAndSortingRepository<Patient, UUID> {
}
