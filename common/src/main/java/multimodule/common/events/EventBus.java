package multimodule.common.events;

public interface EventBus {
    void post(String topic, Object event);
    void register(String topic, Object listener);
}
