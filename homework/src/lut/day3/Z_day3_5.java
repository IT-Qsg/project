package lut.day3;
//因式分解
public class Z_day3_5 {
    public static  void  main(String [] arge){
        Z_day3_5 z5 = new Z_day3_5();
        z5.divide(90);
    }
    //一个数是不是质数
    public boolean p(int num){
        boolean b = false;
        int i = 2;
        for(;i < Math.sqrt(num);i++){
            if(num%i==0)
               b = false;
            else
                b = true;
        }
        return b;
    }/**
     * 参数为被分解的数
     */
    public void divide(int num){
        int i = 2;
        for(;i < num ;i++){
            int a = num%i;
            if(a==0){
                boolean b= p(i);
                if(b==true){
                    if(i == num){
                        System.out.println(num);
                    }else{
                        System.out.println("i="+i);
                        int d = num/i;
                        divide(d);
                    }
                }
            }
        }
    }

}
