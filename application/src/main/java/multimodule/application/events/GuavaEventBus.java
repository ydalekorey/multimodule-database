package multimodule.application.events;

import multimodule.common.events.EventBus;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class GuavaEventBus implements EventBus {

    private Map<String, com.google.common.eventbus.EventBus> eventBuses = new HashMap<>();

    @Override
    public void post(String topic, Object event) {
        com.google.common.eventbus.EventBus topicEventBus = eventBuses.get(topic);

        if (Objects.nonNull(topicEventBus)) {
            topicEventBus.post(event);
        }
    }

    @Override
    public void register(String topic, Object listener) {
        com.google.common.eventbus.EventBus topicEventBus = eventBuses.get(topic);

        if (Objects.isNull(topicEventBus)) {
            topicEventBus = new com.google.common.eventbus.EventBus(topic);
            eventBuses.put(topic, topicEventBus);
        }
        topicEventBus.register(listener);
    }
}
