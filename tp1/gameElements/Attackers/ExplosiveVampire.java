package tp1.gameElements.Attackers;

import tp1.logic.Game;

public class ExplosiveVampire extends Vampire {

    private static final int lives = 5;
    private static final int damage = 1;
    private static final String avatar = "V*V";
    private static final String stringLabel = "EV";

    public ExplosiveVampire(Game game, int positionX, int positionY) {
        super(game, lives, positionX, positionY, damage, avatar,stringLabel);
    }

    @Override
    public boolean receiveSlayerAttack(int damage) {
        reduceLives(damage);
        if(getLives()<=0){
            alive = false;
            explode();
        }
        return true;
    }

    private void receiveAttack(int damage){
        reduceLives(damage);
        if(getLives()<=0){
            alive = false;
        }
    }

    private void explode() {
        game.explosionAttack(posX, posY);
    }

    @Override
    public void receiveExplosion() {
        if(alive) {
            receiveSlayerAttack(1);
        }
    }

    @Override
    public void receiveLightFlashAttack() {
        receiveAttack(getLives());
      //  vampiresOnBoard--;
    }

    @Override
    public void receiveGarlicPush() {
        if(posY + 1 == game.getDimX()){
            receiveAttack(lives);
        } else {
            currentCycle = game.getCycle();
            cycleToMove = currentCycle + 2;
            posY++;
        }
    }


}
