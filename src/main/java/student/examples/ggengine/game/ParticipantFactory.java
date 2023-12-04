package student.examples.ggengine.game;

public interface ParticipantFactory {
    Participant createPlayer(SignUpData signUpData);
    GuestPlayer createGuestPlayer(SignUpData signUpData);
}
