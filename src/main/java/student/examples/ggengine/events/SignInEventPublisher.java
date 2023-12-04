package student.examples.ggengine.events;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import student.examples.ggengine.game.SignUpData;

import java.util.UUID;


@Component
@Slf4j
public class SignInEventPublisher {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishSigningInEvent(String uuidString) {
        log.info("Publishing signing in event..");
        SignInEvent signInEvent = new SignInEvent(this, uuidString);
        applicationEventPublisher.publishEvent(signInEvent);
    }
}

