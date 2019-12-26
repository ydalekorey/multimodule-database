package multimodule.inventory.events;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class TabletDeletedEvent {
    private UUID id;
}
