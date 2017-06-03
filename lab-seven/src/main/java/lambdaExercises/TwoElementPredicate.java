package lambdaExercises;

@SuppressWarnings("all")
@FunctionalInterface
public interface TwoElementPredicate<T>{

    boolean isBetter(T t1, T t2);
}
