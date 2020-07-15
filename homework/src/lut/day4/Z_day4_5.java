package lut.day4;

public class Z_day4_5 {
    //将数组里的数据倒序输出
    public void pxArray(int [] a){
        int i = 0 , len = a.length-1;
        for(;i < (a.length/2);i++){
            int array;
            array = a[i];
            a[i] = a[len];
            a[len] = array;
            len--;
        }
    }
    //统计字符串数组中的字符个数
    public int[] sumStr(String s){
        char [] ch = s.toCharArray();
        int[] ina = new int [ch.length];
        int a = ch.length;
        int i = 0;
        while(i<a){
            ina[i] = ch[i];
            i++;
        }
        return ina;
    }
    public static void main(String [] arge){
        int[] arr = new int[]{12,35,45,13,64,55,88,77};
        Z_day4_5 z = new Z_day4_5();
        z.pxArray(arr);
        for(int i=0;i<arr.length;i++){
            System.out.println("arr["+i+"]"+arr[i]);
        }
        String str = "高温酷暑,上蒸下煮," +
                     "男生出门,马上变成暖男,天庭饱暖,地热方圆," +
                     "女生出门,妆容很难保全,回头一笑百媚生,彩妆粉黛掉颜色";
        int [] ina = z.sumStr(str);
        for(int i = 0; i < ina.length;i++){
            System.out.print("String["+i+"] = "+ina[i]+"      ");
            if((i+1)%3 == 0)
                System.out.println();
        }
        System.out.println();
        for(int i = 0; i < ina.length;i++){
            System.out.print((char)ina[i]);
        }
    }
}
