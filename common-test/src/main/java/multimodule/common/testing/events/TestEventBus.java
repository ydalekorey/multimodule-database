package multimodule.common.testing.events;

import multimodule.common.events.EventBus;

public class TestEventBus implements EventBus {
    @Override
    public void post(String topic, Object event) {

    }

    @Override
    public void register(String topic, Object listener) {

    }
}
