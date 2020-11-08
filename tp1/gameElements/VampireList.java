package tp1.gameElements;

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

    public void removeDeadVampires(){
        for (int i = 0; i <= index; i++) {
            if(!vList[i].isAlive()){
                vList = deleteVampire(vList,i);
            }
        }
    }

    private Vampire[] deleteVampire(Vampire[] v , int i){
        Vampire[] temp = new Vampire[v.length];
        System.arraycopy(v, 0 , temp, 0, i);
        System.arraycopy(v, i +1, temp, i, temp.length-i-1);
        return temp;
    }


    public void move(){
        for (int i = 0; i <= index; i++) {
            vList[i].move();
        }
    }


    public boolean vampireHere(int vx, int y) {
        for (Vampire v: vList) {
            if(v.getPosX() == vx && v.getPosY()==y){
                return true;
            }
        }
        return false;
    }


    private boolean samePos(int x1, int y1, int x2, int y2){
        return x1==x2 && y1==y2;
    }


    public String vampireToString(int x, int y){
        for (int i = 0; i <= index; i++) {
            if(samePos(vList[i].getPosX(), vList[i].getPosY(), x, y)){
                return vList[i].toString();
            }
        }

        return "";
    }


    private boolean sameRow(int vx, int x) {
        return vx==x;
    }

    public boolean isVampireOnLeft() {
        for (Vampire v: vList) {
            if(v.isVampiresOnLeft()){
                return true;
            }
        }

        return false;
    }

//    public boolean isOnLeft(int posX, int posY) {
//        for (int i = 0; i < index; i++) {
//            if(nextTo(vList[i].getPosX(),vList[i].getPosY(),posX,posY)){
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private boolean nextTo(int x, int y, int vx, int vy) {
//        return x==vx && y+1==vy;
//    }

    //    public int currentNumberOfVampires(){
////        return vList.size();
//    }


}
