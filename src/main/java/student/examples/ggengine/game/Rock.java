package student.examples.ggengine.game;

import lombok.Getter;

@Getter
public final class Rock extends Item {
    public Rock(int speedX, int speedY, int top, int left, int rotation, int rotationSpeed) {
        super(100, 100, speedX, speedY, top, left, rotation, rotationSpeed, ItemType.ROCK);
    }

}
