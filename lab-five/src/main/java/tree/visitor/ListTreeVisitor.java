package tree.visitor;

import tree.Branch;
import tree.Leaf;

import java.util.ArrayList;
import java.util.List;

/**
 * A visitor for binary trees that carries out an *in-order* traversal to
 * create a list of the labels in a tree.
 * <p>
 * Created by jb259 on 27/10/16.
 */
@SuppressWarnings("all")
public class ListTreeVisitor implements TreeVisitor<String> {

    private List<String> result;

    public ListTreeVisitor() {
        this.result = new ArrayList<>();
    }

    public String getList() {
        return result.toString();
    }


    @Override
    public void visit(Branch<String> branch) {
        branch.getLeft().accept(this);
        result.add(branch.getLabel());
        branch.getRight().accept(this);
    }

    @Override
    public void visit(Leaf<String> leaf) {
        result.add(leaf.getLabel());
    }
}
