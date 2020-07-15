package reduce;

import java.util.Arrays;

/**
 * @author qsg
 * @version 1.0
 * @Date 2019/9/11 13:54
 * @describe Half Search
 **/
public class Half {
    public int half(int v,int... a){
        int [] h = a ;
        int index = -1;
        int left = 0;
        int right = h.length-1;
        int mid;
       // while(true){//当不存在所查找的值时无法调出循环
       while(left<=right){
//             mid= (left+right)/2;
           mid = left+(right-left)/2;
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
        int value = new Half().half(5, a);
        System.out.println(value);
    }
}
