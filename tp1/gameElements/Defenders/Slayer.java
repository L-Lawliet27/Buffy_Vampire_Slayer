package tp1.gameElements.Defenders;

import tp1.gameElements.IAttack;
import tp1.logic.Game;

public class Slayer extends Defender{

    private static final int cost = 50;
    private static final int lives = 3;
    private static final int damage = 1;
    private static final String avatar = "<->";
    private static final String stringLabel = "S";

    public Slayer(Game game, int positionX, int positionY){
        super(game,cost,lives, positionX, positionY, damage, avatar, stringLabel);
    }

    @Override
    public void attack() {
        if(alive){
            IAttack enemy = game.getEnemyInRow(posX, posY + 1);
            if(enemy != null) enemy.receiveSlayerAttack(damage);
        }
    }



}
