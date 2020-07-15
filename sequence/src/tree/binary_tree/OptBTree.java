package tree.binary_tree;

/**
 * @author qsg
 * @version 1.0
 * @Date 2019/12/4 19:40
 * @describe
 **/
public class OptBTree implements Tree {
    private BTree root;//根[在插入数据时实现]
   /* public OptBTree(){
        this.root = new BTree();
    }*/
   /* public OptBTree(Object date){
        this.root = new BTree(date);
    }*/
    //二叉搜索数遍历
    @Override
    public BTree find(Object key) {
        BTree current = this.root;
        while(current!=null){
            if((int)current.getDate()>(int)key){
                current=current.getLeftChild();//当前数据比查找的数据大，遍历左子树
            }else if((int)current.getDate()<(int)key){
                current=current.getRigntChile();//当前数据比查找的数据小，遍历右子树
            }else{
                return current;
            }
        }
        return null;
    }/*
    查找节点的时间取决于这个节点所在的层数，每一层最多有2n-1个节点，总共N层共有2n-1个节点，那么时间复杂度为O(logN),底数为2
    N为节点的总数
    */

    //类似二叉搜索数搜索[插入数据]
    @Override
    public boolean insert(Object key) {
        BTree node = new BTree(key);
        if(this.root==null){
            this.root = node;
            return true;
        }else {
            BTree current = this.root;
            while(current!=null){
                if((int)current.getDate()>(int)key){
                    //插入左子树
                    if(current.getLeftChild()==null){
                        current.setLeftChild(node);
                        return true;
                    }else {
                        current = current.getLeftChild();
                    }
                }else{
                    if(current.getRigntChile()==null){
                        current.setRigntChile(node);
                        return true;
                    }else {
                        current = current.getRigntChile();
                    }
                }
            }
        }
        return false;
    }
    //插入节点[方式二]
    public boolean Insert(int data) {
        BTree newNode = new BTree(data);
        if(root == null){//当前树为空树，没有任何节点
            root = newNode;
            return true;
        }else{
            BTree current = root;
            BTree parentNode = null;
            while(current != null){
                parentNode = current;
                if((int)current.getDate() > data){//当前值比插入值大，搜索左子节点
                    current = current.getLeftChild();
                    if(current == null){//左子节点为空，直接将新值插入到该节点
                        parentNode.setLeftChild(newNode) ;
                        return true;
                    }
                }else{
                    current = current.getRigntChile();
                    if(current == null){//右子节点为空，直接将新值插入到该节点
                        parentNode.setRigntChile(newNode);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean delete(Object key) {
        /*
        * 删除节点 三种情况
        *1.该节点是叶子节点
        * 2.该节点存在一个叶子节点
        * 3.该节点存在两个叶子节点
        * */
        //查找不到直接返回false
        int value=(int)key;

        //是叶子节点
        return false;
    }
    //先
    @Override
    public void preOrder(BTree current) {
        if(current!=null){
            System.out.println(current.getDate());
            preOrder(current.getLeftChild());
            preOrder(current.getRigntChile());
        }
    }
    //中
    @Override
    public void infixOrder(BTree current) {
       if(current!=null){
           infixOrder(current.getLeftChild());
           System.out.println(current.getDate());
           infixOrder(current.getRigntChile());
       }
    }

    //后
    @Override
    public void postOrder(BTree current) {
        if(current!=null){
            postOrder(current.getLeftChild());
            postOrder(current.getRigntChile());
            System.out.println(current.getDate());
        }
    }

    //查找最大节点
    @Override
    public BTree findMax() {
        BTree maxnode = this.root;
        while(maxnode!=null){
            maxnode=maxnode.getRigntChile();//最大节点在右子树
        }
        return maxnode;
    }

    //查找最小节点
    @Override
    public BTree findMin() {
        BTree mintree = root;
        while (mintree!=null){
            mintree = mintree.getLeftChild();
        }
        return mintree;
    }
}
