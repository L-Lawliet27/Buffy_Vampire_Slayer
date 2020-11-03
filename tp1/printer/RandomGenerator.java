package tp1.printer;

import tp1.logic.*;

public interface RandomGenerator {

    static boolean genVampire(Game game){
        return game.getRandom().nextDouble() <= game.getLvl().getVampireFrequency();
    }

    static int genVampirePosX(Game game){ return game.getRandom().nextInt(game.getDimX() - 1); }

}
