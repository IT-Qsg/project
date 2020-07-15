package tree.binary_tree;

/**
 * @author qsg
 * @version 1.0
 * @Date 2019/12/4 19:31
 * @describe 二叉树树的操作
 **/
public interface Tree {
    //查找节点【数据】
    public BTree find(Object key);
    //插入新节点
    public boolean insert(Object key);
    //删除节点
    public boolean delete(Object key);
    //先序遍历
    public void preOrder(BTree current);
    //中序遍历
    public void infixOrder(BTree current);
    //后序遍历
    public void postOrder(BTree current);
    //找出最大值
    public BTree findMax();
    //找出最小值
    public BTree findMin();
}
