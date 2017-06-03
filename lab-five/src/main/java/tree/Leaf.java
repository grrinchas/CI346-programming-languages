package tree;

import tree.visitor.TreeVisitor;

/**
 * The subclass of BinaryTree that represents a leaf node.
 *
 * Created by jb259 on 27/10/16.
 */
@SuppressWarnings("all")
public class Leaf<T> extends BinaryTree<T> {

    public Leaf(T label) {
        this.label = label;
    }

    @Override
    public void accept(TreeVisitor<T> visitor) {
        visitor.visit(this);
    }

}
