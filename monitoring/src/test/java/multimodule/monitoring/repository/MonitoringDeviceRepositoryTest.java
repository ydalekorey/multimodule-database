package multimodule.monitoring.repository;

import multimodule.common.testing.tescontainers.SharedPostgresContainer;
import multimodule.monitoring.model.Device;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Testcontainers
public class MonitoringDeviceRepositoryTest {

    @Container
    private static final SharedPostgresContainer postgresContainer = SharedPostgresContainer.getInstance();

    @Autowired
    private MonitoringDeviceRepository deviceRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void findBySerialNumberFilter() {
        // GIVEN
        Device expectedDevice = new Device();
        expectedDevice.setAccessToken("some-acces-token");
        expectedDevice.setSerialNumber("some-serial-number");

        entityManager.persistAndFlush(expectedDevice);

        // WHEN
        Optional<Device> actualDevice = deviceRepository.findBySerialNumber(expectedDevice.getSerialNumber());

        // THEN
        assertEquals(actualDevice.get().getAccessToken(), expectedDevice.getAccessToken());
    }
}
