package order;

/**
 * @author qsg
 * @version 1.0
 * @Date 2019/9/11 10:50
 * @describe In order to find
 **/
public class Order {
    //适合大于等于0的数组
    public int orderFind(int s,int... o){
        int [] or= o;
        int index = -1;
        //for (int i : or) { }
        int i = 0;
        for(;i<or.length;i++){
            if(s==or[i]){
                index = i;break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int [] a = {59,3,6,98,6,6,9,8,5,6,7,44,8,69,2,8,2,3,3,9,2};
        //如果i=-1则没有找到
        int i = new Order().orderFind(5, a);
        System.out.println(i);
    }
}