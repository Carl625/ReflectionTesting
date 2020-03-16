import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Prying {

    public Prying(double... variables) {

    }

    public static void main(String[] args) {

        try {

            Constructor[] constructors = Difficult.class.getDeclaredConstructors();
            Difficult.class.getDeclaredMethod("getDouble", new Class[] {Double.class});
            constructors[0].setAccessible(true);
            Difficult cls = (Difficult) constructors[0].newInstance(null, null);

            cls.getDouble(0.0);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
