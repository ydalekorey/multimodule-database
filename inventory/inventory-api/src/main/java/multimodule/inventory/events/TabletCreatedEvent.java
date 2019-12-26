package multimodule.inventory.events;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class TabletCreatedEvent {
    private UUID id;

    private UUID patientId;

    private String applicationAccount;

    private String serialNumber;
}
