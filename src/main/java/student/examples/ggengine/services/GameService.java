package student.examples.ggengine.services;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import student.examples.ggengine.events.CreateGameEvent;
import student.examples.ggengine.events.SignInEvent;
import student.examples.ggengine.game.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@Service
@Getter
@Setter
@Slf4j
public class GameService{
    @Autowired
    private MultiPlayerTeamGameFactory multiPlayerTeamGameFactory;

    private Set<MultiPlayerTeamGame> games;
    private Set<Player> allParticipants;

    public GameService(){
        init();
    }

    public void init(){
        games = new HashSet<>();
        allParticipants = new HashSet<>();
    }

    public void addPlayer(UUID uuid){

        if(games.isEmpty()){
            MultiPlayerTeamGame newGame = multiPlayerTeamGameFactory.createGame();
            games.add(newGame);
        }

        // adding the player to the game
        boolean playerAdded = false;

        Player player = null;
        for (Player currentPlayer :
                allParticipants) {
            if (uuid.equals(currentPlayer.getId())) {
                player = currentPlayer;
            }
        }

        for (MultiPlayerTeamGame game : games) {
            if(game.getGameState().equals(GameState.PENDING)){
                addPlayerToGame(game, player);
                playerAdded = true;
            }

            if(game.getPlayers().size()==4){
                game.setGameState(GameState.STARTED);
            }

            log.info("Game:"+game);
        }

        if(!playerAdded){
            MultiPlayerTeamGame newGame = multiPlayerTeamGameFactory.createGame();

            addPlayerToGame(newGame, player);
            games.add(newGame);

            log.info("New Game:"+newGame);
        }
    }

    private void addPlayerToGame(MultiPlayerTeamGame game, Player player) {

        // get the team with the least players
        Team smallestTeam = null;
        for (String teamName :
                game.getTeams().keySet()) {
            if(smallestTeam == null ||
                    (smallestTeam != null && smallestTeam.getParticipants().size() > game.getTeams().get(teamName).getParticipants().size())){

                smallestTeam = game.getTeams().get(teamName);
            }

        }

        smallestTeam.addParticipant(player);

    }

    @Scheduled(fixedDelay = 1000)
    public void updateFrame(){
        if(!games.isEmpty()){
            // update objects position
        }
    }

    @EventListener
    public void handleGameCreationEvent(CreateGameEvent event) {
        // Your logic to handle the event
        System.out.println("Create game Event Received in Game Service: " + event.getSource());
    }

    @EventListener
    public void handleSigningInEvent(SignInEvent event) {
        // Your logic to handle the event
        System.out.println("Sign in Event Received in Game Service: " + event.getSource());
        UUID uuid = UUID.fromString(event.getUuidString());
        addPlayer(uuid);
    }

    public boolean playerSigned(String uuidString) {
        UUID uuid = UUID.fromString(uuidString);
        for (Participant player : allParticipants) {
            if(player.getId().equals(uuid)) {
                return true;
            }
        }
        return true;
    }
}
