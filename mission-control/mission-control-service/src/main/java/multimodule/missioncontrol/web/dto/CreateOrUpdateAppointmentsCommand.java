package multimodule.missioncontrol.web.dto;

import lombok.Getter;
import lombok.Setter;
import multimodule.missioncontrol.model.Appointment;
import multimodule.missioncontrol.model.Patient;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
public class CreateOrUpdateAppointmentsCommand {

    private UUID patientId;

    private OffsetDateTime dateTime;

    public Appointment toAppointment() {
        Appointment appointment = new Appointment();
        Patient patient = new Patient();
        patient.setId(getPatientId());
        appointment.setPatient(patient);
        setDateTime(getDateTime());
        return appointment;
    }
}
