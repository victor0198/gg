package student.examples.ggengine.events;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StartGameEventPublisher {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishCustomEvent() {
        log.info("Publishing custom event..");
        StartGameEvent customSpringEvent = new StartGameEvent(this);
        applicationEventPublisher.publishEvent(customSpringEvent);
    }
}
