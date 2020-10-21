package tp1.printer;

import tp1.gameElements.Vampire;

import java.util.ArrayList;

public class VampireList {

//    private ArrayList<Vampire> vList;
      private Vampire[] vList;
      private int index = 0;

    public VampireList(int nVampires){
        //vList = new ArrayList<Vampire>();
        vList = new Vampire[nVampires];
    }

    public void addVampire(Vampire v){
        //vList.add(v);
        vList[index++] = v;
    }

    public Vampire getVampire(int i){
//        return vList.get(index);
        return vList[i];
    }

//    public int currentNumberOfVampires(){
////        return vList.size();
//    }


}
