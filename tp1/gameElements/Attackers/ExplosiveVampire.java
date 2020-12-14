package tp1.gameElements.Attackers;

import tp1.logic.Game;

public class ExplosiveVampire extends Vampire {

    public ExplosiveVampire(Game game, int positionX, int positionY) {
        super(game, positionX, positionY);
    }

    @Override
    public boolean receiveSlayerAttack(int damage) {
        lives -= damage;
        if(lives<=0){
            alive = false;
            explode();
        }
        return true;
    }

    private void explode() {
        game.explosionAttack(posX, posY);
    }

    @Override
    public String toString() { return "V*V" + "[" + lives + "]"; }

}
