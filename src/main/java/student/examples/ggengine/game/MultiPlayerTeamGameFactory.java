package student.examples.ggengine.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import student.examples.ggengine.events.CreateGameEventPublisher;

@Component
public class MultiPlayerTeamGameFactory implements GameFactory{
    @Autowired
    CreateGameEventPublisher createGameEventPublisher;

    @Override
    public MultiPlayerTeamGame createGame() {
        MultiPlayerTeamGame newGame = new MultiPlayerTeamGame();

        newGame.getTeams().put("Team A", new Team());
        newGame.getTeams().put("Team B", new Team());

        createGameEventPublisher.publishGameCreationEvent(newGame.getUuid());

        return newGame;
    }
}
