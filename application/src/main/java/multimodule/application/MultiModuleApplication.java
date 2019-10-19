package multimodule.application;

import multimodule.inventory.InventoryConfiguration;
import multimodule.monitoring.MonitoringConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({MonitoringConfiguration.class, InventoryConfiguration.class})
public class MultiModuleApplication {
    public static void main(String[] args) {
        SpringApplication.run(MultiModuleApplication.class, args);
    }
}
