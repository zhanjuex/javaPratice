import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

public class LongTest {
    public static void main(String[] args) {
        Long a = 10000000L;
        Long b = 10000000L;
        System.out.println(a == b);
        int i  = 1;
        i = i++;
        System.out.println(i);
        int count = 0;
        // for(int i = 0;i < 100;i++)
        // {
        //     count = count++;
        // }
        // System.out.println("count = "+count);
        // AbstractQueuedSynchronizer;
        // ReentrantLock;

    }
}
