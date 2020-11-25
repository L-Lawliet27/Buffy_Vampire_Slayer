package tp1.gameElements;

import tp1.logic.Game;

public class Slayer extends GameElement{


    public Slayer(Game game, int positionX, int positionY){
        super(game,50,3, positionX, positionY, 1);
    }

//    public Slayer(Game game, int cost, int lives, int positionX, int positionY) {
//        //super(game, cost, lives, positionX, positionY, 0);
//    }

    @Override
    public boolean receiveVampireAttack(int damage) {
        lives = lives - damage;
        if(lives <= 0) alive = false;
        return true;
    }

    @Override
    public void attack() {
        if(alive){
            IAttack enemy = game.getEnemyInRow(posX, posY + 1);
            if(enemy != null) enemy.receiveSlayerAttack(damage);
        }
    }


    @Override
    public void move() {/*LEAVE EMPTY*/}

    @Override
    public String toString() {
        return "<->" + "[" + lives + "]";
    }


}
