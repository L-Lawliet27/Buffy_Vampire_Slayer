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

    public void attack() {

        for (int i = 0; i <= index; i++) {
            vList[i].attack();
        }

    }

    public void receiveDamage(int posX, int posY, int damage) {

        for (int i = 0; i <= index; i++) {
            if(sameRow(vList[i].getPosX(),posX)){
                for (int j = posY; j <= vList[i].getPosY(); j++) {
                    if(vampireHere(vList[i].getPosX(),j)){
                        vList[i].receiveDamage(damage);
                        break;
                    }
                }
            }
        }

    }


    private boolean vampireHere(int vx, int y) {
        for (Vampire v: vList) {
            if(v.getPosX() == vx && v.getPosY()==y){
                return true;
            }
        }
        return false;
    }

    private boolean sameRow(int vx, int x) {
        return vx==x;
    }

    //    public int currentNumberOfVampires(){
////        return vList.size();
//    }


}
