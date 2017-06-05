import java.lang.reflect.Field;

@SuppressWarnings("all")
public class Runner {

    public static void main(String[] args) throws IllegalAccessException {
        User u = new User(null, "Milton");
        //set default values on `u'

        Field[] fields = u.getClass().getDeclaredFields();

        for (Field f : fields) {
            if (f.isAnnotationPresent(DefaultString.class)) {
                DefaultString a = (DefaultString) f.getAnnotation(DefaultString.class);
                if ((String) f.get(u) == null) {
                    f.set(u, a.value());
                }
            } else if (f.isAnnotationPresent(DefaultInt.class)) {
                DefaultInt a = (DefaultInt) f.getAnnotation(DefaultInt.class);
                if (f.getInt(u) == 0) {
                    f.set(u, a.value());
                }
            }
        }

        System.out.println(u);
    }
}
