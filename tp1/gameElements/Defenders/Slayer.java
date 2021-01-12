package tp1.gameElements.Defenders;

import tp1.gameElements.IAttack;
import tp1.logic.Game;

public class Slayer extends Defender{

    private static final int cost = 50;
    private static final int lives = 3;
    private static final int damage = 1;

    public Slayer(Game game, int positionX, int positionY){
        super(game,cost,lives, positionX, positionY, damage);
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
        return "<->" + "[" + getLives() + "]";
    }

    @Override
    public String stringify(){
        return "S;"+ posX + ";" + posY + ";" + getLives() + "\n";
    }


}
