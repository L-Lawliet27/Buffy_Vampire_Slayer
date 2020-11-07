package tp1.gameElements;

import tp1.gameElements.Slayer;
import tp1.gameElements.Vampire;
import tp1.logic.Game;

import java.util.ArrayList;

public class SlayerList {

//    private ArrayList<Slayer> sList;
    private Slayer[] sList;
    private int index = 0;


    public SlayerList(){
//        sList = new ArrayList<Slayer>();
        int tempSize = 20;
        sList = new Slayer[tempSize];
    }

    public void addSlayer(Game game, int posX, int posY){
//        sList.add(s);
        if(!slayerHere(posX,posY)) {
            sList[index++] = new Slayer(game, posX, posY);
        }
    }

    private boolean slayerHere(int x, int y) {
        for (Slayer s: sList) {
            if(s.getPosX() == x && s.getPosY()==y){
                return true;
            }
        }
        return false;
    }


    public void receiveDamage(int posX, int posY, int damage) {

        for (int i = 0; i <= index; i++) {
            if(nextTo(sList[i].getPosX(),sList[i].getPosY(),posX,posY)){
                sList[i].receiveDamage(damage);
            }
        }
    }

    public void removeDeadSlayers(){
        for (int i = 0; i <= index; i++) {
            if(!sList[i].isAlive()){
                sList = deleteSlayer(sList,i);
            }
        }
    }

    private Slayer[] deleteSlayer(Slayer[] s , int i){
        Slayer[] temp = new Slayer[s.length];
        System.arraycopy(s, 0 , temp, 0, i);
        System.arraycopy(s, i +1, temp, i, temp.length-i-1);
        return temp;
    }


    private boolean nextTo(int sx, int sy, int vx, int vy) {
        return sx==vx && sy+1==vy;
    }


    public void attack() {
        for (int i = 0; i <= index; i++) {
            sList[i].attack();
        }
    }


    private boolean samePos(int x1, int y1, int x2, int y2){
        return x1==x2 && y1==y2;
    }

    public String slayerToString(int x, int y){
        for (int i = 0; i <= index; i++) {
            if(samePos(sList[i].getPosX(), sList[i].getPosY(), x, y)){
                return sList[i].toString();
            }
        }
        return "";
    }


    public boolean isOnLeft(int posX, int posY) {
        for (int i = 0; i <= index; i++) {
            if(nextTo(sList[i].getPosX(),sList[i].getPosY(),posX,posY)){
                return true;
            }
        }
        return false;
    }


}
