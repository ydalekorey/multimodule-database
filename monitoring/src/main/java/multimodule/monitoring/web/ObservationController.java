package multimodule.monitoring.web;

import multimodule.monitoring.model.Observation;
import multimodule.monitoring.service.ObservationService;
import multimodule.monitoring.web.dto.CreateOrUpdateObservationCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/monitoring/observations")
public class ObservationController {

    @Autowired
    private ObservationService service;

    @GetMapping
    @ResponseBody
    public Iterable<Observation> getAll() {
        return service.getAll();
    }

    @PostMapping
    @ResponseBody
    public Observation create(@RequestBody CreateOrUpdateObservationCommand device) {
        return service.create(device.toObservation());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Observation> getById(@PathVariable("id") UUID id) {
        return ResponseEntity.of(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") UUID id, @RequestBody CreateOrUpdateObservationCommand update) {
        Observation observation = update.toObservation();
        observation.setId(id);
        service.update(observation);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity delete(UUID id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
