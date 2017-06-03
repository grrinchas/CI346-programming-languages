package ast;

/**
 * An AST node which represents a binary operator.
 *
 * Created by jb259 on 27/10/16.
 *
 */
@SuppressWarnings("all")
public abstract class BinaryOp<T> extends Exp<T> {
    protected Exp<T> lhs;
    protected Exp<T> rhs;

    public BinaryOp(Exp<T> lhs, Exp<T> rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    public Exp<T> getLhs() {
        return lhs;
    }

    public Exp<T> getRhs() {
        return rhs;
    }
}
