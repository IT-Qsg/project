package lut.day8.exe2;

public class Player {
   /* String role;
    public Player(String role){
        this.role = role;
    }*/
    public FightAble select(String role){
        if("法力角色" == role)
            return new FaShi();
        else
            return  new ZhanShi();
    }
}
