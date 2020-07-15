package shell;

/*
*实现原理 ：先按照希尔曾量分组 然后组内进行插入排序
*
* 8 9 1 7 2      3 5 4 6 0 ->分5组
* 3 5 1 6 0   8 9 4 7 2 ->分两组
* 0   1   3     7   9
*   2   4     5   6   8
* 0 2 1 4 3 5 7 6 9 8 ->分一组
* 0 1 2 3 4 5 6 7 8 9
* */
//希尔排序
public class ShellSort {
    static public int[] shell(int... s){
        int []a = s;
        for(int i = a.length/2; i>=1 ;i/=2)
            for(int j = i;j < a.length ;j++)
                for(int k = j; k >= i&& a[k]<a[k-i];k -= i){
                    a[k] = a[k]^a[k-i];
                    a[k-i] = a[k]^a[k-i];
                    a[k] = a[k]^a[k-i];
                }
        return a;
    }

    public static void main(String[] args) {
        int []a = {5,9,3,9,7,5,9,2,5,6};
        for (int i : shell(a)) {
            System.out.println(i);
        }
    }
}
