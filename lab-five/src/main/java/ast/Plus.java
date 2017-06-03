package ast;

import ast.visitor.ASTVisitor;

/**
 * An AST node representing the addition of the left and right
 * hand expressions.
 *
 * Created by jb259 on 27/10/16.
 */
@SuppressWarnings("all")
public class Plus<T> extends BinaryOp<T> {

    public Plus(Exp<T> lhs, Exp<T> rhs) {
        super(lhs, rhs);
    }

    @Override
    public T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
