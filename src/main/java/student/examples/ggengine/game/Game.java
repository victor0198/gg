package student.examples.ggengine.game;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


public interface Game {
    Set<Item> getItems();

    void setGameState(GameState gameState);

    GameState getGameState();

    UUID getUuid();

}
