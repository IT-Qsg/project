package lut.day3;

public class Z_day3_2 {
    public Z_day3_2(int [] num){
        init(num);
    }
    public void init(int [] num){
        int[] sNum = selectNumList(num);
        int i = 0;
        for(;i<(sNum.length);i++){
            if(sNum[i]!=0)
            System.out.println("第"+(i+1)+"个数字是"+sNum[i]);
        }
    }
    /*
    * 根据数据源选出不重复的数字
    * */
    public int[] selectNumList(int [] num){
        int selNum,c = 0;
        int[] sNum = new int [100];
        for(int i = 0;i<(num.length);i++)
            for(int j = 0;j<(num.length);j++)
                for(int z = 0; z<(num.length);z++){
                    if(num[i]!=num[j] && num[i]!=num[z] && num[j]!=num[z]){
                        selNum = num[i]*100 + num[j]*10 + num[z];
                        sNum[c] = selNum;
                        c++;
                    }
                }
        return sNum;
    }
    public static void main (String [] arge){
        int [] num = {1,2,3,4,5};
        new Z_day3_2(num);

    }
}
