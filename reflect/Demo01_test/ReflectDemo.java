import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class ReflectDemo {
    public static void main(String[] args) {
        Class<TestReflect> testReflectClass = TestReflect.class;
        try {
            TestReflect testReflect = testReflectClass.getDeclaredConstructor().newInstance();
            Field numberField = testReflectClass.getDeclaredField("number");
            numberField.setAccessible(true);
            numberField.set(testReflect, 42);

            List<String> list = Arrays.asList("String 1", "String 2", "String 3");
            Field listString = testReflectClass.getDeclaredField("stringList");
            listString.setAccessible(true);
            listString.set(testReflect, list);

            System.out.println(testReflect.getNumber());
            System.out.println(testReflect.getStringList());
            System.out.println(testReflect.getClass());

            Field[] testReflectClassField = testReflectClass.getFields();
            System.out.println(Arrays.toString(testReflectClassField));
            Field[] testReflectDeclaredField = testReflectClass.getDeclaredFields();
            System.out.println(Arrays.toString(testReflectDeclaredField));

            System.out.println(numberField.getType());
            System.out.println(numberField.getModifiers());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}