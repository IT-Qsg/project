package bubble;

public class Bubble_sort {
    static public int[] bubble(int... a){
        //接受数组a;
        int []b = a;
        int i = 0;
        for(;i<b.length-1;i++){
            int j = 0;
            for(;j<b.length-1-i;j++){
                if(b[j]>b[j+1]){
                    b[j] = b[j]^b[j+1];
                    b[j+1] = b[j]^b[j+1];
                    b[j] = b[j]^b[j+1];
                }
            }
        }
        return b;
    }
    public static void main(String[] args) {
        int [] a = {4,6,9,7,5,9,3,8,2,87};
        bubble(a);
    }
}
