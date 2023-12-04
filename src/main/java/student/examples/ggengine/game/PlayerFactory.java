package student.examples.ggengine.game;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PlayerFactory implements ParticipantFactory{

    public Player createPlayer(SignUpData signUpData) {
        return new Player(UUID.randomUUID(), signUpData.username, signUpData.password);
    }

    public GuestPlayer createGuestPlayer(SignUpData signUpData) {
        return new GuestPlayer(UUID.randomUUID(), signUpData.username);
    }
}
