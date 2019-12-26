package multimodule.monitoring.events;

import com.google.common.eventbus.Subscribe;
import multimodule.careplanning.events.PatientCreatedEvent;
import multimodule.careplanning.events.PatientDeletedEvent;
import multimodule.careplanning.events.PatientUpdatedEvent;
import multimodule.common.events.EventBus;
import multimodule.monitoring.model.Patient;
import multimodule.monitoring.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class PatientEventListener {

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
                .id(patientCreatedEvent.getId())
                .build();

        if (patientService.getById(patient.getId()).isEmpty()) {
            patientService.create(patient);
        }
    }

    @Subscribe
    public void onPatientUpdated(PatientUpdatedEvent patientUpdatedEvent) {
        Patient patient = Patient.builder()
                .id(patientUpdatedEvent.getId())
                .build();
        patientService.update(patient);
    }

    @Subscribe
    public void onPatientDeleted(PatientDeletedEvent patientDeletedEvent) {
        patientService.deleteById(patientDeletedEvent.getId());
    }
}
