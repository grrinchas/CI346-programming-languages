package ast.visitor;

import ast.*;

import java.util.Map;

/**
 * An AST Visitor which evaluates an expression. In order to
 * look up the value of identifiers, the constructor requires a
 * lookup table, or environment, allowing us to look up identifier
 * names.
 * <p>
 * Created by jb259 on 27/10/16.
 */
@SuppressWarnings("all")
public class EvalVisitor implements ASTVisitor<Integer> {
    Map<String, Integer> env;

    public EvalVisitor(Map<String, Integer> env) {
        this.env = env;
    }

    @Override
    public Integer visit(Id<Integer> id) {
        Integer val = env.get(id.getId());
        if (val != null)
            return val;
        throw new RuntimeException("ID doesn't exists");
    }

    @Override
    public Integer visit(Minus<Integer> minus) {
        return minus.getLhs().accept(this) - minus.getRhs().accept(this);
    }

    @Override
    public Integer visit(Plus<Integer> plus) {
        return plus.getLhs().accept(this) + plus.getRhs().accept(this);
    }

    @Override
    public Integer visit(Val<Integer> val) {
        return val.getValue();
    }

    @Override
    public Integer visit(Mult<Integer> mult) {
        return mult.getLhs().accept(this) * mult.getRhs().accept(this);
    }

    @Override
    public Integer visit(Pow<Integer> pow) {
        return (int) Math.pow(pow.getLhs().accept(this), (pow.getRhs()).accept(this));
    }
}
