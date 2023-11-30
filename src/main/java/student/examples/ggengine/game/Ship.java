package student.examples.ggengine.game;

public class Ship extends Item {
    public Ship(int speedX, int speedY, int top, int left, int rotation, int rotationSpeed) {
        super(50, 50, speedX, speedY, top, left, rotation, rotationSpeed, ItemType.SHIP);
    }

}
