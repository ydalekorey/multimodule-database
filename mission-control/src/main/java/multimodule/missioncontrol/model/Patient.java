package multimodule.missioncontrol.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity(name = "missionControlPatient")
@Table(name = "patient", schema = "missioncontrol")
@Getter
@Setter
public class Patient {
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "phone_number")
    private String phoneNumber;
}
