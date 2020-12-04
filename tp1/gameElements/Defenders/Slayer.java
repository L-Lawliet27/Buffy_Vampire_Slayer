package tp1.gameElements.Defenders;

import tp1.gameElements.IAttack;
import tp1.logic.Game;

public class Slayer extends Defender{

    public Slayer(Game game, int positionX, int positionY){
        super(game,50,3, positionX, positionY, 1);
    }

    @Override
    public void attack() {
        if(alive){
            IAttack enemy = game.getEnemyInRow(posX, posY + 1);
            if(enemy != null) enemy.receiveSlayerAttack(damage);
        }
    }

    @Override
    public String toString() {
        return "<->" + "[" + lives + "]";
    }


}
