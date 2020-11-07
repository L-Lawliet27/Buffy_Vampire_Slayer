package tp1.logic;

import tp1.gameElements.Vampire;
import tp1.gameElements.SlayerList;
import tp1.gameElements.VampireList;

public class GameObjectBoard{

    private final Level level;
    private SlayerList slayerList;
    private VampireList vampireList;
    private Game game;
    private final int VampirePosY;
    //private GameElement[] gameElements;
//    private static int nElements = 0;
    private static int nVampiresAdded = 0;


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
        return slayerList.slayerToString(x,y);
    }


    public String vampireToString(int x, int y){
        return vampireList.vampireToString(x,y);
    }



//    private GameElement getElemAt(int x, int y){
//        for (int i = 0; i < nElements; i++) {
//            if(gameElements[i].confirmPosition(x,y)){
//                return gameElements[i];
//            }
//        }
//        return null;
//    }


    private void instantiateVampires(){
        for (int i = 0; i < level.getNumberOfVampires(); i++) {
            addVampire();
        }
    }

    public void addVampire(){

        if(nVampiresAdded < level.getNumberOfVampires()) {

            if (game.getRandom().nextDouble() <= game.getLvl().getVampireFrequency()) {

                int posX = game.getRandom().nextInt(game.getDimX() - 1);

                if (!vampireList.vampireHere(posX, VampirePosY)) {
                    vampireList.addVampire(game, posX, VampirePosY);
                    nVampiresAdded++;
                }
            }
        }
    }


    public void addSlayer(int x, int y){

        if(!vampireList.vampireHere(x,y)){
            slayerList.addSlayer(game,x,y);
        }

    }

    public void move(){
        vampireList.move();
    }

    public void removeDead(){
        vampireList.removeDeadVampires();
        slayerList.removeDeadSlayers();
    }

    public int getRemainingVampires(){
        return Vampire.getVampiresRemaining();
    }

    public int getVampiresOnBoard(){
        return Vampire.getVampiresOnBoard();
    }

    public void attack() {
        vampireList.attack();
        slayerList.attack();
    }

    public void slayerDamage(int posX, int posY, int damage) {
        slayerList.receiveDamage(posX,posY,damage);
    }

    public void vampireDamage(int posX, int posY, int damage) {
        vampireList.receiveDamage(posX,posY,damage);
    }

    public boolean leftFree(int posX, int posY) {
        return slayerList.isOnLeft(posX, posY);
    }






//    public Slayer getSlayer(int i) {
//        return slayerList.getSlayer(i);
//    }

//    public Vampire getVampire(int i){
//        return vampireList.getVampire(i);
//    }


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




//    private void removeDead(GameElement[] gameElements){
//        for (int i = 0; i < nElements; i++) {
//            if(!gameElements[i].isAlive()){
//                gameElements[i].setAlive();
//                removeGameElements(i);
//                nElements--;
//            }
//        }
//    }




//    private boolean sameRow(int x1, int x2){
//        return x1 == x2;
//    }


//    private boolean sameCords(GameElement n1, GameElement n2){
//        return n1.getPosX() == n2.getPosX() && n1.getPosY() == n2.getPosY();
//    }

//    private boolean toTheLeft(Vampire n1, Slayer n2){
//        return n1.getPosX() == n2.getPosX() && n1.getPosY() == n2.getPosY() + 1;
//    }

//    private boolean toTheLeft(GameElement n1, GameElement n2){
//        return n1.getPosX() == n2.getPosX() && n1.getPosY() == n2.getPosY() + 1;
//    }

//    private boolean sameCords(int x1, int y1, int x2, int y2){
//        return x1==x2 && y1==y2;
//    }

//    private boolean isLeftFree(int x, int y){
//        for (GameElement e: gameElements) {
//            if(sameCords(e.getPosX(), e.getPosY(), x, y)){
//                return true;
//            }
//        }
//        return false;
//    }



//    private boolean isLeftFree(int x, int y){
//        for (Vampire v: vampireList.getvList()) {
//            if(sameCords(v.getPosX() , v.getPosY(), x, y)){
//                return true;
//            }
//        }
//        return false;
//    }

//
//    public void addGameElements(GameElement element){
//        gameElements = expand(gameElements, element);
//    }

//    public void removeGameElements(int i){
//        gameElements = deleteElem(gameElements, i);
//    }




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



}
