package tp1.gameElements.Defenders;

import tp1.gameElements.GameElement;
import tp1.logic.Game;

public class Defender extends GameElement {

    public Defender(Game game, int cost, int lives, int positionX, int positionY, int damage, String avatar) {
        super(game, cost, lives, positionX, positionY, damage, avatar);
    }

    @Override
    public boolean receiveVampireAttack(int damage) {
        reduceLives(damage);
        if(lives <= 0) alive = false;
        return true;
    }

    @Override
    public void move() {
        //LEAVE EMPTY
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
