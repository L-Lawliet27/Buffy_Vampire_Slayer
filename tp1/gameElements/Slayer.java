package tp1.gameElements;

import tp1.logic.Game;

public class Slayer extends GameElement {

    Slayer(Game game, int positionX, int positionY){
        super(game,50,3, positionX, positionY, 0);
    }

    Slayer(Game game, int cost, int lives, int positionX, int positionY) {
        super(game, cost, lives, positionX, positionY, 0);
    }

    @Override
    public void attack() {
        //TODO
    }

    @Override
    public void move() {/*LEAVE EMPTY*/}

    @Override
    public void receiveDamage() {
        //TODO
    }

    @Override
    public String toString() {
        return "<->" + "[" + getLives() + "]";
    }
}
