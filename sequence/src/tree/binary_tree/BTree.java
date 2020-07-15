package tree.binary_tree;


/**
 * @author qsg
 * @version 1.0
 * @Date 2019/12/4 19:30
 * @describe 二叉树的定义
 **/
public class BTree {
    private Object date; //数据
    private BTree leftChild; //左孩子
    private BTree rigntChile;//右孩子
    public BTree(){

    }
    public BTree(Object date){
        this.date=date;
    }
    public void println(){
        System.out.println("\t"+date);
    }

    public Object getDate() {
        return date;
    }

    public BTree getLeftChild() {
        return leftChild;
    }

    public BTree getRigntChile() {
        return rigntChile;
    }

    public void setDate(Object date) {
        this.date = date;
    }

    public void setLeftChild(BTree leftChild) {
        this.leftChild = leftChild;
    }

    public void setRigntChile(BTree rigntChile) {
        this.rigntChile = rigntChile;
    }
}
