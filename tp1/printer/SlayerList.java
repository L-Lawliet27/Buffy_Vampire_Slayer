package tp1.printer;

import tp1.gameElements.Slayer;
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

    public void addSlayer(Slayer s){
//        sList.add(s);
        sList[index++] = s;
    }

    public Slayer getSlayer(int i){
//        return sList.get(index);
        return sList[i];
    }

}
