package tp1.printer;

import tp1.gameElements.Slayer;
import tp1.gameElements.Vampire;

public class GameObjectBoard {

    private SlayerList slayerList;
    private VampireList vampireList;

    public GameObjectBoard(SlayerList sL, VampireList vL){
        slayerList = sL;
        vampireList = vL;
    }


    public Slayer getSlayer(int i) {
        return slayerList.getSlayer(i);
    }

    public Vampire getVampire(int i){
        return vampireList.getVampire(i);
    }
}
