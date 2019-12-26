package multimodule.inventory.events;

import com.google.common.eventbus.Subscribe;
import multimodule.careplanning.events.PatientCreatedEvent;
import multimodule.careplanning.events.PatientDeletedEvent;
import multimodule.careplanning.events.PatientUpdatedEvent;
import multimodule.common.events.EventBus;
import multimodule.inventory.model.Patient;
import multimodule.inventory.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InventoryPatientEventListener {

    @Autowired
    private EventBus eventBus;

    @Autowired
    private PatientService patientService;

    @PostConstruct
    public void registerYourself() {
        eventBus.register("careplanning", this);
    }

    @Subscribe
    public void onPatientCreated(PatientCreatedEvent patientCreatedEvent) {
        Patient patient = Patient.builder()
                .firstName(patientCreatedEvent.getFirstName())
                .lastName(patientCreatedEvent.getLastName())
                .id(patientCreatedEvent.getId())
                .build();

        if (patientService.getById(patient.getId()).isEmpty()) {
            patientService.create(patient);
        }
    }

    @Subscribe
    public void onPatientUpdated(PatientUpdatedEvent patientUpdatedEvent) {
        Patient patient = Patient.builder()
                .firstName(patientUpdatedEvent.getFirstName())
                .lastName(patientUpdatedEvent.getLastName())
                .id(patientUpdatedEvent.getId())
                .build();
        patientService.update(patient);
    }

    @Subscribe
    public void onPatientDeleted(PatientDeletedEvent patientDeletedEvent) {
        patientService.deleteById(patientDeletedEvent.getId());
    }
}
