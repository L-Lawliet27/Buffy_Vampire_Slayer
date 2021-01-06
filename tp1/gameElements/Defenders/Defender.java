package tp1.gameElements.Defenders;

import tp1.gameElements.GameElement;
import tp1.logic.Game;

public class Defender extends GameElement {

    public Defender(Game game, int cost, int lives, int positionX, int positionY, int damage) {
        super(game, cost, lives, positionX, positionY, damage);
    }

    @Override
    public boolean receiveVampireAttack(int damage) {
        lives = lives - damage;
        if(lives <= 0) alive = false;
        return true;
    }

    @Override
    public void move() {
        //LEAVE EMPTY
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public void generateIncome() {
        //LEAVE EMPTY
    }

    @Override
    public String stringify() {
        return null;
    }

    @Override
    public void attack() {
        //LEAVE EMPTY
    }
}
