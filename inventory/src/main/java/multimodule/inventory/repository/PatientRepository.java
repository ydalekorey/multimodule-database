package multimodule.inventory.repository;

import multimodule.inventory.model.Patient;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("inventoryPatientRepository")
public interface PatientRepository extends PagingAndSortingRepository<Patient, UUID> {
}
