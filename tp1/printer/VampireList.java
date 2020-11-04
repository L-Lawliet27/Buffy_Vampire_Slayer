package tp1.printer;

import tp1.gameElements.Vampire;
import tp1.logic.Game;

import java.util.ArrayList;

public class VampireList {

//    private ArrayList<Vampire> vList;
      private Vampire[] vList;
      private int index = 0;

    public VampireList(int nVampires){
        //vList = new ArrayList<Vampire>();
        vList = new Vampire[nVampires];
    }

    public void addVampire(Game game, int PosX, int PosY){
        //vList.add(v);
        vList[index++] = new Vampire(game, PosX, PosY);
    }

    public Vampire getVampire(int i){
//        return vList.get(index);
        return vList[i];
    }

    public Vampire[] getvList() {
        return vList;
    }

    public void setvList(Vampire[] v){
        vList = v;
    }

    //    public int currentNumberOfVampires(){
////        return vList.size();
//    }


}
