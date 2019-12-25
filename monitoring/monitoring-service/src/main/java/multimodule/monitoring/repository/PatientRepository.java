package multimodule.monitoring.repository;

import multimodule.monitoring.model.Patient;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("monitoringPatientRepository")
public interface PatientRepository extends PagingAndSortingRepository<Patient, UUID> {
}
