package tree.base_tree;

/**
 * @author qsg
 * @version 1.0
 * @Date 2019/12/3 19:38
 * @describe
 **/
public class OperTree implements Visit {
    //先跟遍历
    public void preRoot(Tree tree){
        if(!tree.isEmpty()){
            visit(tree);
            for (Tree child : tree.getChilds()) {
                if(child!=null)
                    preRoot(child);
            }
        }
    }
    //后根遍历
    public void postRoot(Tree tree){
        if(!tree.isEmpty()){
            for (Tree child : tree.getChilds()) {
                if(child!=null){
                    preRoot(child);
                }
            }
            visit(tree);
        }
    }
    @Override
    public void visit(Tree tree) {
        System.out.print("\t"+tree.getRootData());
    }
}
