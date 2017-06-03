package tree.visitor;

import tree.Branch;
import tree.Leaf;

/**
 * A visitor for binary trees that carries out a *pre-order* traversal to add together
 * all the labels in a tree whose labels are numbers.
 *
 * Created by jb259 on 27/10/16.
 */
@SuppressWarnings("all")
public class SumTreeVisitor implements TreeVisitor<Integer> {

    private int sum = 0;

    public int getSum() {
        return sum;
    }

    @Override
    public void visit(Branch<Integer> branch) {
        sum += branch.getLabel();
        branch.getLeft().accept(this);
        branch.getRight().accept(this);
    }

    @Override
    public void visit(Leaf<Integer> leaf) {
        sum += leaf.getLabel();
    }
}
