package student.examples.ggengine.game;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class Team implements ParticipantCollection{
    Set<Participant> participants = new HashSet<>();

    @Override
    public void addParticipant(Participant participant) {
        participants.add(participant);
    }

    @Override
    public void removeParticipant(Participant participant) {
        participants.remove(participant);
    }

    @Override
    public String toString() {
        return "Team{" +
                "participants=" + participants +
                '}';
    }
}
