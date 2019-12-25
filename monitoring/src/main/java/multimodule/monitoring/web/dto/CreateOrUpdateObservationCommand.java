package multimodule.monitoring.web.dto;

import lombok.Getter;
import lombok.Setter;
import multimodule.monitoring.model.Observation;

import java.time.OffsetDateTime;

@Getter
@Setter
public class CreateOrUpdateObservationCommand {
    private OffsetDateTime dateTime;

    private Integer value;

    public Observation toObservation() {
        Observation observation = new Observation();
        observation.setDateTime(getDateTime());
        observation.setValue(getValue());
        return observation;
    }
}
