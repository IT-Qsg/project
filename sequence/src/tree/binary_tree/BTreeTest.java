package tree.binary_tree;

/**
 * @author qsg
 * @version 1.0
 * @Date 2019/12/4 21:36
 * @describe
 **/
public class BTreeTest {
    public static void main(String[] args) {
            OptBTree bt = new OptBTree();
            bt.insert(50);
            bt.insert(20);
            bt.insert(80);
            bt.insert(10);
            bt.insert(30);
            bt.insert(60);
        BTree root = new BTree(10);
        BTree b1 = new BTree(11);
        BTree b2 = new BTree(12);
        BTree b3 = new BTree(18);
        root.setLeftChild(b1);
        root.setRigntChile(b2);
        b2.setLeftChild(b3);
        //中序遍历
        bt.infixOrder(root);
    }
}
