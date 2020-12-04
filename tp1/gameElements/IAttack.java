package tp1.gameElements;

public interface IAttack {

    void attack();
    default boolean receiveSlayerAttack(int damage){return false;}
    default boolean receiveVampireAttack(int damage){return false;}
    default void receiveLightFlashAttack(){}
    default void receiveGarlicPush(){}
    default void receiveExplosion(){}

}
