import ast.*;
import ast.visitor.EvalVisitor;
import ast.visitor.Pow;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by jb259 on 28/10/16.
 */
@SuppressWarnings("all")
public class ASTVisitorTest {
    Exp<Integer> exp;
    Map<String, Integer> env;

    @Before
    public void setUp() {
        env = new HashMap<>();
        exp = new Plus(new Id("x"), new Minus(new Val(99), new Id("y")));
        env = new HashMap<>();
        env.put("x", 42);
        env.put("y", 19);
    }

    @Test
    public void testEvalTreeVisitor() {
        EvalVisitor ev = new EvalVisitor(env);
        int result = exp.accept(ev);
        assertEquals(result, 122);
        System.out.println(result);
    }

    @Test
    public void testEvalTreeVisitorUndecl() {
        EvalVisitor ev = new EvalVisitor(env);
        try {
            Exp<Integer> undeclared = new Id("z");
            undeclared.accept(ev);
            assert(false);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }


    @Test
    public void testMultPowVisitor() {
        env = new HashMap<>();
        exp = new Mult<>(new Id<>("x"), new Pow<>(new Val<>(2), new Minus<>(new Id<>("y"), new Val<>(1))));
        env.put("x", 42);
        env.put("y", 19);
        EvalVisitor ev = new EvalVisitor(env);
        int result = exp.accept(ev);
        assertEquals(result, 11010048);
        System.out.println(result);
    }

    @After
    public void tearDown() throws Exception {

    }

}