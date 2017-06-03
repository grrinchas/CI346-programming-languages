package ast;

import ast.visitor.ASTVisitor;

/**
 * An AST node representing the subtraction of the right hand expression from
 * the left hand expression.
 * <p>
 * Created by jb259 on 27/10/16.
 */
@SuppressWarnings("all")
public class Minus<T> extends BinaryOp<T> {

    public Minus(Exp<T> lhs, Exp<T> rhs) {
        super(lhs, rhs);
    }

    @Override
    public T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
