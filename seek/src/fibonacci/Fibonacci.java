package fibonacci;

import java.util.Arrays;

/**
 * @author qsg
 * @version 1.0
 * @Date 2019/9/11 19:27
 * @describe Fibonacci search :分割点是黄金分割点0.618
 **/
public class Fibonacci {
    public int fibonacci(int value,int... a){
        int []f = a;
        int index = -1;
        int length = f.length;
        //获得斐波那契数列
        int[] fb = makeFbArray(length);


        int k = 0;
        while (length > fb[k] - 1) {// 找出数组的长度在斐波数列（减1）中的位置，将决定如何拆分
            k++;
        }
        int[] temp = Arrays.copyOf(f, fb[k] - 1);// 构造一个长度为fb[k] - 1的新数列
        for (int i = length; i < temp.length; i++) {
            if (i >= length) {
                temp[i] = f[length - 1];
            }
        }
        int low = 0;
        int hight = f.length - 1;
        while (low <= hight) {
            int middle = low + fb[k - 1] - 1;
            if (temp[middle] > value) {
                hight = middle - 1;
                k = k - 1;
            } else if (temp[middle] < value) {
                low = middle + 1;
                k = k - 2;
            } else {
                if (middle <= hight) {
                    return middle;// 若相等则说明mid即为查找到的位置
                } else {
                    return hight;// middle的值已经大于hight,进入扩展数组的填充部分,即最后一个数就是要查找的数。
                }
            }
        }
        return index;
    }
    //构造斐波那契数列
    public  int[] makeFbArray(int length) {
        int [] array = null;
        if(length>2){
            array = new int [length];
            array[0] = 1;
            array[1] = 1;
            for(int i = 2;i<length;i++){
                array[i] = array[i-1]+array[i-2];
            }
        }
        return array;
    }
    /*
    //递归
     public static int recurse(int[] array, int[] fb, int a, int low, int hight,
            int k) {
        if (array == null || array.length == 0 || a < array[low]
                || a > array[hight] || low > hight) {
            return -1;
        }
        int middle = low + fb[k - 1] - 1;
        if (a < array[middle]) {
            return recurse(array, fb, a, low, middle - 1, k - 1);
        } else if (a > array[middle]) {
            return recurse(array, fb, a, middle + 1, hight, k - 2);
        } else {
            if (middle <= hight) {
                return middle;
            } else {
                return hight;
            }
        }
    }
     */
    public static void main(String[] args) {
        int [] a = {59,3,6,98,6,6,9,8,5,6,7,44,8,69,2,8,2,3,3,9,2};
        Arrays.sort(a);
        int fibonacci = new Fibonacci().fibonacci(5, a);
        System.out.println(fibonacci);
    }
}
/*
class a{

   private b  c= new b(){
       @Override
       public void c() {
       }
   };

}
interface b{

    void c();
}
class d{
    public d(String s) {
    }
    void t(){}
}

class e{
    public static void main(String[] args) {
         new d("dd"){
             public void f(){
                System.out.println("nnnnnn");
            }
        };

    }
}*/
