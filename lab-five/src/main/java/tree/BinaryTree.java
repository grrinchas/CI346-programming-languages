package tree;

import tree.visitor.VisitableTree;

/**
 * The base class for nodes in a binary tree. Implements VisitableTree
 * so that all nodes in the tree can be visited.
 *
 * Created by jb259 on 27/10/16.
 */
@SuppressWarnings("all")
public abstract class BinaryTree<T> implements VisitableTree<T> {
    protected T label;

    public T getLabel() {
        return label;
    }

}
