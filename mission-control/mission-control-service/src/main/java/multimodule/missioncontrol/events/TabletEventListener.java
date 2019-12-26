package multimodule.missioncontrol.events;

import com.google.common.eventbus.Subscribe;
import multimodule.common.events.EventBus;
import multimodule.inventory.events.TabletCreatedEvent;
import multimodule.inventory.events.TabletDeletedEvent;
import multimodule.inventory.events.TabletUpdatedEvent;
import multimodule.missioncontrol.model.Patient;
import multimodule.missioncontrol.model.Tablet;
import multimodule.missioncontrol.service.TabletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TabletEventListener {

    @Autowired
    private EventBus eventBus;

    @Autowired
    private TabletService tabletService;

    @PostConstruct
    public void registerYourself() {
        eventBus.register("inventory", this);
    }

    @Subscribe
    public void onTabletCreated(TabletCreatedEvent tabletCreatedEvent) {
        Tablet tablet = Tablet.builder()
                .applicationAccount(tabletCreatedEvent.getApplicationAccount())
                .patient(Patient.builder().id(tabletCreatedEvent.getPatientId()).build())
                .id(tabletCreatedEvent.getId())
                .build();

        if (tabletService.getById(tablet.getId()).isEmpty()) {
            tabletService.create(tablet);
        }
    }

    @Subscribe
    public void onTabletUpdated(TabletUpdatedEvent tabletUpdatedEvent) {
        Tablet tablet = Tablet.builder()
                .applicationAccount(tabletUpdatedEvent.getApplicationAccount())
                .patient(Patient.builder().id(tabletUpdatedEvent.getPatientId()).build())
                .id(tabletUpdatedEvent.getId())
                .build();
        tabletService.update(tablet);
    }

    @Subscribe
    public void onTabletDeleted(TabletDeletedEvent tabletDeletedEvent) {
        tabletService.deleteById(tabletDeletedEvent.getId());
    }
}
