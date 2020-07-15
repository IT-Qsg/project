package lut.day8.exe2;

public class PlayerTest {
    public static void main(String[] args) {
        Player p = new Player();
        FightAble f = p.select("法力角色");
        f.specialFight();
        f.comonFight();
        FightAble fi = p.select("武力角色");
        fi.specialFight();
        fi.comonFight();
    }
}
