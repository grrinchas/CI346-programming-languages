import org.junit.Test;

import java.util.Optional;
import java.util.function.Function;

import static org.junit.Assert.*;

@SuppressWarnings("all")
public class OptionalTest {

    @Test
    public void leftIdentityTest() throws Exception {
        Function<Integer, Optional<Integer>> f = (a) -> Optional.of(a * 5);
        Function<Integer, Optional<Integer>> g = (a) -> Optional.of(a + 5);
        assertEquals(Optional.of(50).flatMap(f).get(), f.apply(50).get());
        assertEquals(Optional.of(50).flatMap(Optional::of), Optional.of(50));
        assertEquals(Optional.of(50).flatMap(f).flatMap(g), Optional.of(50).flatMap(a -> f.apply(a).flatMap(g)));
    }

}