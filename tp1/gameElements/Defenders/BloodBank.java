package tp1.gameElements.Defenders;

import tp1.logic.Game;

public class BloodBank extends Defender {

    private int income;
    private static final int lives = 1;
    private static final int damage = 0;
    private static final String avatar = "B-B";

    public BloodBank(Game game, int positionX, int positionY, int cost) {
        super(game, cost, lives, positionX, positionY, damage, avatar);
        income = (int) Math.ceil((cost * 0.1));
    }

    @Override
    public void generateIncome(){
        game.receiveIncome(income);
    }


    @Override
    public String toString() {
        return avatar + "[" + cost + "]";
    }

    @Override
    public String stringify(){
        return "B;"+ posX + ";" + posY + ";" + getLives() + ";" + cost + "\n";
    }
}
