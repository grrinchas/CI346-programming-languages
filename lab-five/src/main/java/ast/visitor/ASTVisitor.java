package ast.visitor;

import ast.*;
import tree.Branch;

/**
 * The base class of Visitors for ASTs. This interface needs to contain an
 * overloaded `visit' method for every subclass of Exp (i.e. everything
 * which might appear in an expression). The return type of the `visit' methods
 * has to match the return type of the `accept' methods in the AST nodes.
 *
 * Created by jb259 on 27/10/16.
 */
@SuppressWarnings("all")
public interface ASTVisitor<T> {

    T visit(Id<T> id);
    T visit(Minus<T> minus);
    T visit(Plus<T> plus);
    T visit(Val<T> val);
    T visit(Mult<T> mult);
    T visit(Pow<T> pow);

}
