package student.examples.ggengine.events;

import org.springframework.context.ApplicationEvent;

public class StartGameEvent extends ApplicationEvent {
//    private String message;

    public StartGameEvent(Object source) {
        super(source);
    }
}