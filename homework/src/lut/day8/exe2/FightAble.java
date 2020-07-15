package lut.day8.exe2;

public interface FightAble {
    public abstract void specialFight();
    default void comonFight(){
        System.out.println("普通攻击");
    }
}
