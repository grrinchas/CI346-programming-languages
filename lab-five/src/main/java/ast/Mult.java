package ast;

import ast.visitor.ASTVisitor;

@SuppressWarnings("all")
public class Mult<T> extends BinaryOp<T> {

    public Mult(Exp<T> lhs, Exp<T> rhs) {
        super(lhs, rhs);
    }

    @Override
    public T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
