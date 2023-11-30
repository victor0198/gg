package student.examples.ggengine.services;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import student.examples.ggengine.events.StartGameEvent;
import student.examples.ggengine.game.Game;
import student.examples.ggengine.game.Item;
import student.examples.ggengine.game.Rock;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;


@Service
@Getter
@Setter
@Slf4j
public class GameService implements ApplicationListener<StartGameEvent>{

    private Set<Game> games;


    public GameService(){
        init();
    }

    public void init(){
        games = new HashSet<>();
        games.add(new Game());

        Game game = games.stream().findFirst().get();
        game.getItems().add(
            new Rock(0,0,0,0,0,0)
        );
    }

    @Override
    public void onApplicationEvent(StartGameEvent event) {
        log.info("Received start game event!");
        addGame();
    }

    public void addGame(){
        log.info("Adding game! The game list:");
        Game newGame = new Game();

        Random random = new Random();

        newGame.getItems().add(new Rock(random.nextInt(100), 0,0,0,0,0));

        games.add(newGame);

        for (Game game :
                games) {
            log.info(game.toString());
        }
    }

    @Scheduled(fixedDelay = 10)
    public void updateFrame(){

        Game game = games.stream().findFirst().get();

        Item item = game.getItems().stream().findFirst().get();
        game.getItems().remove(item);
        game.getItems().add(new Rock(
                item.getSpeedX(),
                item.getSpeedY(),
                item.getTop(),
                item.getLeft()+1,
                item.getRotation(),
                item.getRotationSpeed()
        ));
    }
}
