package selection;

public class Select_sort {
    static public int[] selece(int... sel){
        //获取数据
        int[] s = sel;
        for(int i = 0;i<s.length;i++){
            //假设每次取到的第一个元素最大
            int max = s[i];
            for(int j = i+1;j<s.length;j++){
                if(max<s[j]){
                int temp = max;
                max=s[j];
                s[j] = temp;}
            }
            s[i]=max;
        }
        return s;
    }
    public static void main(String[] args) {
        int[] s ={5,9,6,6,7,32,94,6};
        int[] selece = selece(s);
        for (int i : selece) {
            System.out.println(i);
        }
    }
}
