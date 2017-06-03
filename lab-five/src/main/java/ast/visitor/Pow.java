package ast.visitor;

import ast.BinaryOp;
import ast.Exp;

@SuppressWarnings("all")
public class Pow<T> extends BinaryOp<T> {
    public Pow(Exp<T> lhs, Exp<T> rhs) {
        super(lhs, rhs);
    }

    @Override
    public T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
