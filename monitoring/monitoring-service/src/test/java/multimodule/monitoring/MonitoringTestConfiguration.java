package multimodule.monitoring;

import multimodule.common.events.EventBus;
import multimodule.common.testing.events.TestEventBus;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
@EnableAutoConfiguration
public class MonitoringTestConfiguration extends MonitoringConfiguration {
    @Bean
    public EventBus eventBus() {
        return new TestEventBus();
    }
}
