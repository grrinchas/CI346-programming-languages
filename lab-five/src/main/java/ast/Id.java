package ast;

import ast.visitor.ASTVisitor;

/**
 * An AST node that represents an identifier, such as `x'.
 *
 * Created by jb259 on 27/10/16.
 */
@SuppressWarnings("all")
public class Id<T> extends Exp<T> {
    private String id;

    public Id(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
