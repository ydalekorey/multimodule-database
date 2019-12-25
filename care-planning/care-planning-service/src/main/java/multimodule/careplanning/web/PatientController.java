package multimodule.careplanning.web;

import multimodule.careplanning.model.Patient;
import multimodule.careplanning.service.PatientService;
import multimodule.careplanning.web.dto.CreateOrUpdatePatientCommand;
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
@RequestMapping("/care-planning/patients")
public class PatientController {
    @Autowired
    private PatientService service;

    @GetMapping
    @ResponseBody
    public Iterable<Patient> getDevices() {
        return service.getAll();
    }

    @PostMapping
    @ResponseBody
    public Patient create(@RequestBody CreateOrUpdatePatientCommand create) {
        return service.create(create.toPatient());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getById(@PathVariable("id") UUID id) {
        return ResponseEntity.of(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") UUID id, @RequestBody CreateOrUpdatePatientCommand update) {
        Patient patient = update.toPatient();
        patient.setId(id);
        service.update(patient);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity delete(UUID id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
