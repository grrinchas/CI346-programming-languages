package ast;

import ast.visitor.ASTVisitor;

/**
 * An AST node representing an integer value.
 *
 * Created by jb259 on 27/10/16.
 */
@SuppressWarnings("all")

public class Val<T> extends Exp<T> {
    private T value;

    public Val(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    @Override
    public T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
