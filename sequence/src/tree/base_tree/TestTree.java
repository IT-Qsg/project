package tree.base_tree;

/**
 * @author qsg
 * @version 1.0
 * @Date 2019/12/3 19:45
 * @describe
 **/
public class TestTree {
    public static void main(String[] args) {
        //A [B,C]
        //B [D]
        //C [E,F]
        Tree root = new Tree("A");
        root.addNode(new Tree("B"));
        root.addNode(new Tree("C"));
       /* Tree tb = root.getChild(0);
        tb.addNode(new Tree("D"));
        Tree tc = root.getChild(1);
        tc.addNode(new Tree("E"));
        tc.addNode(new Tree("F"));*/
        System.out.println("rootdata   "+root.getRootData());
        System.out.println("树的节点个数   "+root.size());
        System.out.println("树的深度[起始值为0]  "+root.dept());
//        Tree tt = new Tree();
//        System.out.println(tt.isEmpty());
        OperTree operTree = new OperTree();
        System.out.println("先根");
        operTree.preRoot(root);
        System.out.println();
        System.out.println("后根");
        operTree.postRoot(root);
    }
}
