package student.examples.ggengine.events;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class CreateGameEventPublisher {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishGameCreationEvent(UUID uuid) {
        log.info("Publishing game creation event..");
        CreateGameEvent customSpringEvent = new CreateGameEvent(this, uuid);
        applicationEventPublisher.publishEvent(customSpringEvent);
    }
}
