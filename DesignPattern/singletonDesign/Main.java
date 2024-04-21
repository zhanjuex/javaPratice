import java.io.*;
import java.lang.reflect.Constructor;

public class Main {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 10; i++) {
           new Thread(() -> {
               HungryMan.getInstance();
               LazyMan.getInstance();
               LazyManDCL.getInstance();
               Holder.getInstance();
           }).start();
        }

        // 反射
        try {
            Constructor<LazyManDCL> lazyManDCLConstructor = LazyManDCL.class.getDeclaredConstructor(null);
            lazyManDCLConstructor.setAccessible(true);
            LazyManDCL lazyManDCL = lazyManDCLConstructor.newInstance();
            LazyManDCL lazyManDCL2 = lazyManDCLConstructor.newInstance();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = in.readLine();
        return;
    }
}
