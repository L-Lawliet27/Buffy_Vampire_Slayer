package tp1.printer;

import tp1.gameElements.Vampire;

import java.util.ArrayList;

public class VampireList {

    private ArrayList<Vampire> vList;

    public VampireList(){
        vList = new ArrayList<Vampire>();
    }

    public void addVampire(Vampire v){
        vList.add(v);
    }

    public Vampire getVampire(int index){
        return vList.get(index);
    }

    public int numberOfVampires(){
        return vList.size();
    }


}
