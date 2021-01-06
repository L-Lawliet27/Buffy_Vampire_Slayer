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

    private void receiveAttack(int damage){
        lives -= damage;
        if(lives<=0){
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
        receiveAttack(lives);
        vampiresOnBoard--;
    }

    @Override
    public String toString() { return "V*V" + "[" + lives + "]"; }

    @Override
    public String stringify(){
        return "EV;"+ posX + ";" + posY + ";" + getCycleTillMove() + "\n";
    }

}
