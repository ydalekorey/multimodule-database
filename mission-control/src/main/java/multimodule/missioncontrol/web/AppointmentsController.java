package multimodule.missioncontrol.web;

import multimodule.missioncontrol.model.Appointment;
import multimodule.missioncontrol.service.AppointmentService;
import multimodule.missioncontrol.web.dto.CreateOrUpdateAppointmentsCommand;
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
@RequestMapping("/mission-control/patients")
public class AppointmentsController {
    @Autowired
    private AppointmentService service;

    @GetMapping
    @ResponseBody
    public Iterable<Appointment> getAll() {
        return service.getAll();
    }

    @PostMapping
    @ResponseBody
    public Appointment create(@RequestBody CreateOrUpdateAppointmentsCommand create) {
        return service.create(create.toAppointment());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getById(@PathVariable("id") UUID id) {
        return ResponseEntity.of(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") UUID id, @RequestBody CreateOrUpdateAppointmentsCommand update) {
        Appointment appointment = update.toAppointment();
        appointment.setId(id);
        service.update(appointment);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity delete(UUID id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
