import model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        Resume r = new Resume();
        System.out.println(r);

        Class<? extends Resume> aClass = r.getClass();
        Field field = aClass.getDeclaredFields()[0];
        field.setAccessible(true);
        String uuid = (String) field.get(r);
        System.out.println(uuid);
        field.set(r, "new_uuid");
        System.out.println(field.get(r));

        Method toString = aClass.getDeclaredMethod("toString", null);
        System.out.println(toString.invoke(r, null));


    }
}
