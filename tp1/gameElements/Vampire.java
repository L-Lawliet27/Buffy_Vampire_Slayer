package tp1.gameElements;

import tp1.logic.Game;

public class Vampire extends GameElement{

    Vampire(Game game, int positionX, int positionY){
        super(game,0,5, positionX, positionY, 0);
    }

    Vampire(Game game, int lives, int positionX, int positionY) {
        super(game,0, lives, positionX, positionY, 0);
    }

    @Override
    public void attack() {
        //TODO
    }

    @Override
    public void move() {
        //TODO
    }

    @Override
    public void receiveDamage() {
        //TODO
    }

    @Override
    public String toString() {
        return "V^V" + "[" + getLives() + "]";
    }

    private void bite(){
        //TODO
    }

}
