package student.examples.ggengine.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import student.examples.ggengine.game.SignUpData;

import java.util.UUID;

@Getter
public class SignInEvent extends ApplicationEvent {
    private final String uuidString;

    public SignInEvent(Object source, String uuidString) {
        super(source);
        this.uuidString = uuidString;
    }
}