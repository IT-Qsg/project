package lut.day3;

/**
 * 判断任意两个整数之间有多少个素数
 */
public class Z_day3_3 {

    public int primSum(int num1,int num2){
        int pnum = 1;
        if(num1<num2){
            for(;num1<num2;num1++){
                int i = 2;
                for(;i<Math.sqrt(num2);i++){
                    if(num1%i==0){
                        break;
                    }else{
                        System.out.print(num1+"\t");
                        if(pnum%5==0)
                            System.out.println();
                        pnum++;
                        break;
                    }
                }
            }
        }else
            primSum(num2,num1);
        return pnum;
    }
    public static void main(String[] args){
        Z_day3_3 ad = new Z_day3_3();
        System.out.println("素数有："+(ad.primSum(101,200)-1)+"个");
    }
}
