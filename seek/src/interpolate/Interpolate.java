package interpolate;

import java.util.Arrays;

/**
 * @author qsg
 * @version 1.0
 * @Date 2019/9/11 19:00
 * @describe Interpolate Search :在二分查找的基础上更改查找点mid
 **/
public class Interpolate {
    public int interpolate(int v,int... a){
        int [] h = a ;
        int index = -1;
        int left = 0;
        int right = h.length-1;
        int mid;
        // while(true){//当不存在所查找的值时无法调出循环
        while(left<=right){
            //更改查找点
            mid = left+(right-left)*((v-h[left])/(h[right]-h[left]));
            if(v==h[mid]){
                index = mid;
                break;
            }
            if(v>h[mid]){
                left = mid+1;
            }
            if(v<h[mid]){
                right = mid-1;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        int [] a = {59,3,6,98,6,6,9,8,5,6,7,44,8,69,2,8,2,3,3,9,2};
        Arrays.sort(a);
        //不存在返回-1
        int value = new Interpolate().interpolate(10, a);
        System.out.println(value);
    }

}
