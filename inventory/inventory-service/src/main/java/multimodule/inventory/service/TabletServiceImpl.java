package multimodule.inventory.service;

import multimodule.common.events.EventBus;
import multimodule.inventory.events.TabletCreatedEvent;
import multimodule.inventory.events.TabletDeletedEvent;
import multimodule.inventory.events.TabletUpdatedEvent;
import multimodule.inventory.model.Patient;
import multimodule.inventory.model.Tablet;
import multimodule.inventory.repository.TabletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TabletServiceImpl implements TabletService {

    @Autowired
    private EventBus eventBus;

    @Autowired
    private TabletRepository repository;

    @Override
    public Tablet create(Tablet tablet) {
        repository.save(tablet);
        TabletCreatedEvent createdEvent = TabletCreatedEvent.builder()
                .applicationAccount(tablet.getApplicationAccount())
                .serialNumber(tablet.getSerialNumber())
                .patientId(Optional.ofNullable(tablet.getPatient()).map(Patient::getId).orElse(null))
                .id(tablet.getId())
                .build();
        eventBus.post("inventory", createdEvent);
        return tablet;
    }

    @Override
    public Optional<Tablet> getById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public void update(Tablet tablet) {
        repository.save(tablet);
        TabletUpdatedEvent updatedEvent = TabletUpdatedEvent.builder()
                .applicationAccount(tablet.getApplicationAccount())
                .serialNumber(tablet.getSerialNumber())
                .patientId(Optional.ofNullable(tablet.getPatient()).map(Patient::getId).orElse(null))
                .id(tablet.getId())
                .build();
        eventBus.post("inventory", updatedEvent);
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
        TabletDeletedEvent deletedEvent = TabletDeletedEvent.builder()
                .id(id)
                .build();
        eventBus.post("inventory", deletedEvent);
    }

    @Override
    public Iterable<Tablet> getAll() {
        return repository.findAll();
    }
}
