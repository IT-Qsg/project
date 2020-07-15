package lut.day17.homework;

public class HomeWork1 {
    /*
    * 1                                                        ---->>1
    * 1   1                                                    ---->>2
    * 1   1   1                                                ---->>3
    * 1   1   1   1                                            ---->>4
    * 1   1   1   1   1                                        ---->>5
    * 1   1   1   1   1   1   1                                ---->>7
    * 1   1   1   1   1   1   1   1   1   1                    ---->>10
    * */

    int i = 1,j=1,k=2;
    private void rabbitNum(){

        while(i<5){
            i++;j++;
        }

       while(i>=5&&j<20) {
           i+=k++;
           j++;
       }
        System.out.println(i);

}

    public static void main(String[] args) {
       new HomeWork1().rabbitNum();
    }

}
