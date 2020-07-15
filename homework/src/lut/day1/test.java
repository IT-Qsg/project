package lut.day1;

public class test {

    public static void main(String arges[]) {
        System.out.println("你好！");
        int x = 1,y = 1;
       /* if(x++==2 & ++y==2)
        {
            x =7;
        }
        System.out.println("x="+x+",y="+y);*/
        /*if(x++==2 && ++y==2)
        {
            x =7;
        }
        System.out.println("x="+x+",y="+y);*/
        if(x++==1 || ++y==1)
        {
            x =7;
        }
        System.out.println("x="+x+",y="+y);
        boolean b = true;

        if(b==false)
            System.out.println("a");
        else if(b)
            System.out.println("b");
        else if(!b)
            System.out.println("c");
        else
            System.out.println("d");
    }
}