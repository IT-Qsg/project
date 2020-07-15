package tree.base_tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author qsg
 * @version 1.0
 * @Date 2019/12/3 18:32
 * @describe 树的定义与实现
 **/
public class Tree {
    //孩子表示法
    //使用list 集合实现
    private Object data;
    private List<Tree> childs;

    //空树
    public Tree(){
        this.data = null;
        this.childs = new ArrayList<>();
        this.childs.clear();
    }
    //包含数据的树
    public Tree(Object data){
        this.data = data;
        this.childs = new ArrayList<>();
        this.childs.clear();//清空节点
    }
    //添加子树【节点】
    public void addNode(Tree tree){
        this.childs.add(tree);
    }
    //清空树
    public void clearTree(){
        this.data = null;
        this.childs.clear();
    }
    //判断树是否为空
    public boolean isEmpty(){
        if(childs.isEmpty()&& this.data==null)
            return true;
        return false;
    }
    //判断是否为叶子几点
    public boolean isLeaf(){
        if(this.childs.isEmpty())
            return true;
        return false;
    }
    //获得树的深度
    public int dept(){
        return dept(this);
    }

    //求树的深度  -》 递归[得出最大子树的深度] 从0开始
    /*
    方法存在问题，数据太多可能出现栈溢出
    */
    private int dept(Tree tree){
        if(tree.isEmpty())//树是否为空
            return 0;
        else if(tree.isLeaf())//是否为叶子节点
            return 0;//如果起始值为1 则返回1
        else {
            int treeNum = childs.size();
//            System.out.println(treeNum);
            int[] a = new int[treeNum];
            for (int i =0;i<a.length;i++) {
                if(childs.get(i).isEmpty())
                    a[i]= 0;//根节点从0开始
                else {
//                    System.out.println("数据"+childs.get(i).data);
                    a[i]=dept(childs.get(i))+1;//递归
                }
            }
            Arrays.sort(a);//升序排序
//            System.out.println(Arrays.toString(a));
            return a[treeNum-1];//得出最大的深度
        }
    }
    //得到某个树的第 i 个子树
    public Tree getChild(int i){
        return childs.get(i);
    }
    //获取某个树的第一个孩子
    public Tree getFirstChile(){
        return childs.get(0);
    }
    //获取某个树的最后一个孩子
    public Tree getLastChile(){
        return childs.get(childs.size()-1);
    }
    //获取子树
    public List<Tree> getChilds(){
        return childs;
    }
    //获得根节点数据
    public Object getRootData(){
        return data;
    }
    //获得根
    public Tree root(){
        return this;
    }
    //设置根节点数据
    public void setRootData(Object data){
        this.data=data;
    }

    //求节点的个数
    public int size(){
        return size(this);
    }
    /*
    方法存在问题，数据太多可能出现栈溢出
    */
    private int size(Tree tree){
        if(tree.isEmpty())
            return 0;
        else if(tree.isLeaf()){
            return 1;
        }else {
            int count = 1;//树自己
            int n = childs.size();
            for (int i = 0; i < n; i++) {
                if(!childs.get(i).isEmpty()){
                    count+=size(childs.get(i));//获得孩子的个数
                }
            }
            return count;
        }
    }
}
