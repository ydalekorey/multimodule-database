package multimodule.inventory.web.dto;

import lombok.Getter;
import lombok.Setter;
import multimodule.inventory.model.Patient;
import multimodule.inventory.model.Tablet;

import java.util.Optional;
import java.util.UUID;

@Getter
@Setter
public class CreateOrUpdateTabletCommand {
    private String applicationAccount;

    private String serialNumber;

    private UUID patientId;

    public Tablet toTablet() {
        Tablet tablet =  new Tablet();
        tablet.setApplicationAccount(getApplicationAccount());
        tablet.setSerialNumber(getSerialNumber());
        tablet.setPatient(Optional.ofNullable(getPatientId()).map(patientId -> Patient.builder().id(patientId).build()).orElse(null));
        return tablet;
    }
}
