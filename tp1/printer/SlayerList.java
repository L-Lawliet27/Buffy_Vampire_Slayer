package tp1.printer;

import tp1.gameElements.Slayer;
import java.util.ArrayList;

public class SlayerList {

    private ArrayList<Slayer> sList;

    public SlayerList(){
        sList = new ArrayList<Slayer>();
    }

    public void addSlayer(Slayer s){
        sList.add(s);
    }

    public Slayer getSlayer(int index){
        return sList.get(index);
    }

}
