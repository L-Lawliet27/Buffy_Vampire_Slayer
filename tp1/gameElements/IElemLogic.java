package tp1.gameElements;

import tp1.logic.Game;

public interface IElemLogic {

    default boolean canAddVampire(){ return Game.getRandom().nextDouble() <= Game.getLvl().getVampireFrequency();}

    default int initialVampirePosition(int dimY){ return Game.getRandom().nextInt(dimY);}

    default boolean sameRow(int x1, int x2){ return x1 == x2;}

    default boolean sameCoords(int x1, int y1, int x2, int y2){ return x1==x2 && y1==y2; }

    default boolean outOfBounds(int x, int y){ return x-1 == y && y == -1;}

}
