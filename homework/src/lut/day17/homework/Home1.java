package lut.day17.homework;

public class Home1 {
    public static void main(String[] args) {

        int i = rNum(20);
        System.out.println(i);
    }
    static int rNum(int month){
        if(month==1)return 1;
        if(month==2)return 1;

        return rNum(month-1)+rNum(month-2);
    }
}
