package student.examples.ggengine.game;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Game {
    private GameState gameState = GameState.PENDING;
    private Set<Item> items = new HashSet<>();
//  private Set<Player> players;
}
