package multimodule.inventory.web;

import multimodule.inventory.model.Tablet;
import multimodule.inventory.service.TabletService;
import multimodule.inventory.web.dto.CreateOrUpdateTabletCommand;
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
@RequestMapping("/inventory/tablets")
public class TabletController {

    @Autowired
    private TabletService service;

    @GetMapping
    @ResponseBody
    public Iterable<Tablet> getDevices() {
        return service.getAll();
    }

    @PostMapping
    @ResponseBody
    public Tablet create(@RequestBody CreateOrUpdateTabletCommand create) {
        return service.create(create.toTablet());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tablet> getById(@PathVariable("id") UUID id) {
        return ResponseEntity.of(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") UUID id, @RequestBody CreateOrUpdateTabletCommand update) {
        Tablet device = update.toTablet();
        device.setId(id);
        service.update(device);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity delete(UUID id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
