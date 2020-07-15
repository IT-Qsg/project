package merge;
import  static java.lang.System.out;
//归并排序
public class Merge {
    public static void main(String[] args) {
        int [] a = {1,5,9,6,8,4,3,8,7,3,6,9,8,5,6,6,6};
        int []b = new int[a.length];

        new Merge().mergeSort(a,b,0,a.length-1);
        for (int i : a) {
            out.println(i);
        }
    }
     public void mergeSort(int[] me ,int[] temp ,int left,int right){

        if(left<right){
            int middle = (left+right)/2;
            mergeSort(me,temp,left,middle);//左子序列
            mergeSort(me,temp,middle+1,right);//右子序列
            //将左子序列与右子序列合并
            mergeLeftAndRight(me,temp,left,middle,right);
        }
    }
    private void mergeLeftAndRight(int[] me, int[] temp, int left, int middle,int right) {
         int i = left;
         int j = middle+1;
         int k = 0;//合并数组索引
        while(i<=middle&&j<=right){
            temp[k++] = me[i] <= me[j] ? me[i++] : me[j++];
        }

        while (i <=middle){
        temp[k++] = me[i++];
    }
        while ( j<=right){
            temp[k++] = me[j++];
        }
        //把数据复制回原数组
        for (i=0; i<k; ++i){
            me[left+i] = temp[i];
        }

    }
}
