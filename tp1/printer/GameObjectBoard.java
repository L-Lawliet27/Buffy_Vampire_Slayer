package tp1.printer;

import tp1.gameElements.GameElement;
import tp1.gameElements.Slayer;
import tp1.gameElements.Vampire;
import tp1.logic.Game;
import tp1.logic.Level;

import java.lang.reflect.Array;
import java.util.Arrays;

public class GameObjectBoard{

    private final Level level;
    private SlayerList slayerList;
    private VampireList vampireList;
    private Game game;
    private int VampirePosY;
    //private GameElement[] gameElements;
//    private static int nElements = 0;
    private static int nVampires = 0;
    private static int nSlayers = 0;


    public GameObjectBoard(Game game){
        this.game = game;
        this.level = game.getLvl();
        slayerList = new SlayerList();
        vampireList = new VampireList(level.getNumberOfVampires());
        //gameElements = new GameElement[0];
        VampirePosY = game.getDimY()-1;
        instantiateVampires();
    }


//    public String toString(int x, int y){
//
//        if(getElemAt(x,y) != null){
//            return getElemAt(x,y).toString();
//        }
//        return "";
//    }


    public String slayerToString(int x, int y){

        if(getSlayerAt(x,y) != null){
            return getSlayerAt(x,y).toString();
        }
        return "";
    }


    public String vampireToString(int x, int y){

        if(getVampireAt(x,y) != null){
            return getVampireAt(x,y).toString();
        }
        return "";
    }



//    private GameElement getElemAt(int x, int y){
//        for (int i = 0; i < nElements; i++) {
//            if(gameElements[i].confirmPosition(x,y)){
//                return gameElements[i];
//            }
//        }
//        return null;
//    }


    private Vampire getVampireAt(int x, int y){
        for (int i = 0; i < nVampires; i++) {
            if(vampireList.getVampire(i).confirmPosition(x,y)){
                return vampireList.getVampire(i);
            }
        }
        return null;
    }


    private Slayer getSlayerAt(int x, int y){
        for (int i = 0; i < nSlayers; i++) {
            if(slayerList.getSlayer(i).confirmPosition(x,y)){
                return slayerList.getSlayer(i);
            }
        }
        return null;
    }




    private void instantiateVampires(){
        for (int i = 0; i < level.getNumberOfVampires(); i++) {
            addVampire();
        }
    }

    public void addVampire(){
        if(game.getRandom().nextDouble() <= game.getLvl().getVampireFrequency()) {

            int posX = game.getRandom().nextInt(game.getDimX() - 1);

            if(getVampireAt(posX, VampirePosY) == null) {
                vampireList.addVampire(game, posX, VampirePosY);
                nVampires++;
            }
        }
    }

    public void addSlayer(int x, int y){
        slayerList.addSlayer(game,x,y);
        nSlayers++;

    }


    public Slayer getSlayer(int i) {
        return slayerList.getSlayer(i);
    }

    public Vampire getVampire(int i){
        return vampireList.getVampire(i);
    }


//    public void update(){
//        for (int i = 0; i < nElements; i++) {
//            updateAttacks(gameElements[i]);
//            if(gameElements[i].toString() != null){
//                if(isLeftFree(gameElements[i].getPosX(), gameElements[i].getPosY() - 1)) {
//                    gameElements[i].move();
//                }
//            }
//            updateAttacks(gameElements[i]);
//        }
//        removeDead(gameElements);
//        addVampire();
//    }

    public void update(){
        for (int i = 0; i < nVampires; i++) {
            updateSlayerAttacks(vampireList.getVampire(i));
            //updateVampireAttacks(slayerList.getSlayer(i));

            if(isLeftFree(vampireList.getVampire(i).getPosX(), vampireList.getVampire(i).getPosY() - 1)) {
                vampireList.getVampire(i).move();
            }
        }

        for (int i = 0; i < nSlayers; i++) {
            updateVampireAttacks(slayerList.getSlayer(i));
        }
        removeDeadVampires();
        removeDeadSlayers();
        addVampire();
    }





//    private void updateAttacks(GameElement gameElement){
//        if(gameElement.isAlive()){
//            for (int i = 0; i < nElements; i++) {
//                if(!gameElement.equals(gameElements[i])){
//
//                    if(sameCords(gameElement, gameElements[i])){
//                        gameElement.receiveDamage();
//                    }
//
//                    if(toTheLeft(gameElement, gameElements[i])){
//                        gameElement.attack(gameElements[i]);
//                    }
//                }
//            }
//        }
//    }



        private void updateVampireAttacks(Slayer slayer){
        if(slayer.isAlive()){
            for (int i = 0; i < nVampires; i++) {

                    if(toTheLeft(vampireList.getVampire(i), slayer)){
                        vampireList.getVampire(i).attack(slayer);
                    }
            }
        }
    }


    private void updateSlayerAttacks(Vampire vampire){
        if(vampire.isAlive()){
            for (int i = 0; i < nSlayers; i++) {

                if(sameRow(vampire.getPosX(), slayerList.getSlayer(i).getPosX())){
                    if(isLeftFree(vampire.getPosX(),vampire.getPosY() -1)){
                        slayerList.getSlayer(i).attack(vampire);
                    }
                }

            }
        }
    }


//    private void removeDead(GameElement[] gameElements){
//        for (int i = 0; i < nElements; i++) {
//            if(!gameElements[i].isAlive()){
//                gameElements[i].setAlive();
//                removeGameElements(i);
//                nElements--;
//            }
//        }
//    }


    private void removeDeadVampires(){
        for (int i = 0; i < nVampires; i++) {
            if(!vampireList.getVampire(i).isAlive()){
                vampireList.getVampire(i).setAlive();
                removeVampires(i);
                nVampires--;
            }
        }
    }

    private void removeDeadSlayers(){
        for (int i = 0; i < nSlayers; i++) {
            if(!slayerList.getSlayer(i).isAlive()){
                slayerList.getSlayer(i).setAlive();
                removeSlayers(i);
                nSlayers--;
            }
        }
    }


    private boolean sameRow(int x1, int x2){
        return x1 == x2;
    }


//    private boolean sameCords(GameElement n1, GameElement n2){
//        return n1.getPosX() == n2.getPosX() && n1.getPosY() == n2.getPosY();
//    }

    private boolean toTheLeft(Vampire n1, Slayer n2){
        return n1.getPosX() == n2.getPosX() && n1.getPosY() == n2.getPosY() + 1;
    }

//    private boolean toTheLeft(GameElement n1, GameElement n2){
//        return n1.getPosX() == n2.getPosX() && n1.getPosY() == n2.getPosY() + 1;
//    }

    private boolean sameCords(int x1, int y1, int x2, int y2){
        return x1==x2 && y1==y2;
    }

//    private boolean isLeftFree(int x, int y){
//        for (GameElement e: gameElements) {
//            if(sameCords(e.getPosX(), e.getPosY(), x, y)){
//                return true;
//            }
//        }
//        return false;
//    }



    private boolean isLeftFree(int x, int y){
        for (Vampire v: vampireList.getvList()) {
            if(sameCords(v.getPosX() , v.getPosY(), x, y)){
                return true;
            }
        }
        return false;
    }

//
//    public void addGameElements(GameElement element){
//        gameElements = expand(gameElements, element);
//    }

//    public void removeGameElements(int i){
//        gameElements = deleteElem(gameElements, i);
//    }

    public void removeVampires(int i){
        vampireList.setvList(deleteVampire(vampireList.getvList(), i));
    }

    public void removeSlayers(int i){
        slayerList.setsList(deleteSlayer(slayerList.getsList(), i));
    }


//    //TO DELETE ONCE THEY LET US USE ARRAYLISTS
//    private GameElement[] expand( GameElement[] g, GameElement e) {
//
//        GameElement[] expandedArray = Arrays.copyOf(g, g.length +1);
//        expandedArray[expandedArray.length - 1] = e;
//        nElements++;
//        return expandedArray;
//    }

//    //TO DELETE ONCE THEY LET US USE ARRAYLISTS
//    private GameElement[] deleteElem(GameElement[] g, int i){
//        GameElement[] temp = new GameElement[g.length];
//        System.arraycopy(g, 0 , temp, 0, i);
//        System.arraycopy(g, i +1, temp, i, temp.length-i-1);
//        return temp;
//    }

    private Vampire[] deleteVampire(Vampire[] v , int i){
        Vampire[] temp = new Vampire[v.length];
        System.arraycopy(v, 0 , temp, 0, i);
        System.arraycopy(v, i +1, temp, i, temp.length-i-1);
        return temp;
    }

    private Slayer[] deleteSlayer(Slayer[] s , int i){
        Slayer[] temp = new Slayer[s.length];
        System.arraycopy(s, 0 , temp, 0, i);
        System.arraycopy(s, i +1, temp, i, temp.length-i-1);
        return temp;
    }

    public int getRemainingVampires(){
        return Vampire.getVampiresRemaining();
    }

    public int getVampiresOnBoard(){
        return Vampire.getVampiresOnBoard();
    }

}
