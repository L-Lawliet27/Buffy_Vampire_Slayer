package tp1.logic;

public interface IElemLogic {

    static boolean canAddVampire(){ return Game.getRandom().nextDouble() <= Game.getLvl().getVampireFrequency();}

    static int initialVampirePosition(int dimY){ return Game.getRandom().nextInt(dimY);}

    static boolean sameRow(int x1, int x2){ return x1 == x2;}

    static boolean sameCoords(int x1, int y1, int x2, int y2){ return x1==x2 && y1==y2; }

    static boolean outOfBounds(int x, int y){ return x == y || y <= -1 || x-1 == y;}

    static boolean verticalBounds(int x, int z){ return x <= -1 || x > z;}

}
