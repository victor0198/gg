package student.examples.ggengine.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.util.UUID;

@Getter
public class CreateGameEvent extends ApplicationEvent {
    private final UUID uuid;

    public CreateGameEvent(Object source, UUID uuid) {
        super(source);
        this.uuid = uuid;
    }
}