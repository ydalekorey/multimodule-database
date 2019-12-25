package multimodule.monitoring.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity(name = "monitoringPatient")
@Table(name = "patient", schema = "monitoring")
@Getter
@Setter
public class Patient {
    @Id
    @Column(name = "id")
    private UUID id;
}
