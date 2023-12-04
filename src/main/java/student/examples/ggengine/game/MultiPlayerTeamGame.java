package student.examples.ggengine.game;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MultiPlayerTeamGame implements Game, HasTeams, HasPlayers {

    UUID uuid = UUID.randomUUID();
    GameState gameState = GameState.PENDING;
    Set<Item> items = new HashSet<>();
    Map<String, Team> teams = new HashMap<>();
    Set<Participant> participants = new HashSet<>();

    @Override
    public Set<Participant> getPlayers() {

        Set<Participant> players = new HashSet<>();
        for (String teamName :
                teams.keySet()) {
            players.addAll(teams.get(teamName).getParticipants());
        }

        return players;
    }

}
