package multimodule.inventory.service;

import multimodule.inventory.model.Tablet;
import multimodule.inventory.repository.TabletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TabletServiceImpl implements TabletService {

    @Autowired
    private TabletRepository repository;

    @Override
    public Tablet create(Tablet tablet) {
        return repository.save(tablet);
    }

    @Override
    public Optional<Tablet> getById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public void update(Tablet tablet) {
        repository.save(tablet);
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public Iterable<Tablet> getAll() {
        return repository.findAll();
    }
}
