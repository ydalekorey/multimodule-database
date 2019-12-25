package multimodule.careplanning.web.dto;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import multimodule.careplanning.model.Patient;

import java.time.LocalDate;

@ApiModel("Care Planning Patient")
@Getter
@Setter
public class CreateOrUpdatePatientCommand {

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private LocalDate birthDate;

    public Patient toPatient() {
        Patient patient = new Patient();
        patient.setFirstName(getFirstName());
        patient.setLastName(getLastName());
        patient.setBirthDate(getBirthDate());
        patient.setPhoneNumber(getPhoneNumber());
        return patient;
    }
}
