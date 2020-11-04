package tp1.printer;

import tp1.gameElements.Slayer;
import tp1.logic.Game;

import java.util.ArrayList;

public class SlayerList {

//    private ArrayList<Slayer> sList;
    private Slayer[] sList;
    private int tempSize = 15;
    private int index = 0;

    public SlayerList(){
//        sList = new ArrayList<Slayer>();
        sList = new Slayer[tempSize];
    }

    public void addSlayer(Game game, int posX, int posY){
//        sList.add(s);
        sList[index++] = new Slayer(game,posX,posY);
    }

    public Slayer getSlayer(int i){
//        return sList.get(index);
        return sList[i];
    }

    public Slayer[] getsList() {
        return sList;
    }

    public void setsList(Slayer[] sList) {
        this.sList = sList;
    }
}
