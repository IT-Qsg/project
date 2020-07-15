package lut.day4;

public class Z_day4_2 {
    public static void main(String [] arge){
        int a = 2,b;
        b = a << 3;
        //System.out.println(b);
        Z_day4_2 z = new Z_day4_2();
       // z.array();
       // z.cmoArray();
        int [] d = {15,55,88,3,35};
        //z.selArray(d);
      //  z.bArray(d);
       // z.insert(d);
       // luckNum();
        authNum();

    }
    public void array(){
        int mul = 1;
        int [] array = new int [10];
        for(int i =0;i < array.length;i++){
            array[i] = i+1;
            mul *=(i+1);
        }
        System.out.println(mul);
    }
    public void cmoArray(){
        int [] array2,array1 = {2,3,5,7,11,13,17,19};
        array2 = array1;
        int i = 0;
        for(;i < array2.length;i++){
            if(i%2 == 0){
                array2[i] = i;
            }
            System.out.println(array1[i]);
        }
    }
    //选择排序
    public void selArray(int [] a){
       for(int i = 0 ;i < a.length ; i++)
           for(int j = (i+1); j < a.length ;j++){
           if(a[i]>=a[j]){
               int r ;
               r = a[i];
               a[i] = a[j];
               a[j] = r;
           }
       }
       for(int i = 0 ; i < a.length ; i++){
           System.out.println("a["+i+"]="+a[i]);
       }
    }
    //冒泡排序
    public void bArray(int [] a){
        int i = 0;
        for(;i< a.length-1;i++){
            int j = 0;
            for(;j<(a.length-i-1);j++){
                if(a[j] >= a[j+1]){
                    int r;
                    r = a[j+1];
                    a[j+1] = a[j];
                    a[j] = r;
                }
            }
        }
        for(int z = 0;z < a.length;z++)
            System.out.println("a["+z+"]="+a[z]);
    }
    //插入排序
    public void insert(int [] a){
       /* for(int i = 0; i < a.length-1 ; i++){
            if(a[i] > a[i+1]){
                for(int j = 0 ; j < i-1;j++){
                    if(a[j]>a[i+1]){
                        int r = a[j];
                        a[j] = a[i+1];
                        for(int z = j+1;z<=(i+1);z++){
                            int b =a[z];
                            a[z] = r;
                            r = b;
                        }
                    }else{
                        if(((a[i+1]>a[j]) && (a[i+1]< a[j+1]))||(a[i+1] == a[j] || (a[i+1]==a[j+1]))){
                            int d = a[i];
                            for(int x =(j+1);x<a.length;x++){
                                int v = a[j+1];
                                a[j+1] = d;
                                d = v;
                            }

                        }
                    }
                }
            }
        }
        for(int n = 0;n < a.length;n++)
        System.out.println(a[n]);*/
       int length = a.length;
       for(int i = 1;i<length;i++){
           int key = a[i];
           int j = i-1;
           while(j>=0 && a[j] > key){
               a[j+1] = a[j];
               j--;
           }
           a[j+1] = key;
       }
        for(int n = 0;n < a.length;n++)
            System.out.print(a[n] +"   ");
    }
    public static void luckNum(){
        int [] s = {4545,458,96,54,96,596,66,66,94,10};
        int a = (int)(Math.random()*s.length);
        System.out.println(a);
        System.out.println(s[a]);
    }
    public static void authNum(){
        int i = 10;
        while(i>0) {
            // 97-122
            //65-90
            int zm = (int) (Math.random() * 26);
            char sa =(char)(zm + 97);
            //System.out.println(sa);
            int Zm = (int) (Math.random() * 26);
            int Za = Zm + 65;
            int n1 = (int) (Math.random() * 10);
            int n2 = (int) (Math.random() * 10);
            i--;
            System.out.println(sa+" "+(char)Za+" "+n1+" "+n2);
        }
    }
}
