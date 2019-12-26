package multimodule.careplanning.events;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Builder
public class PatientUpdatedEvent {
    private UUID id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private LocalDate birthDate;
}
