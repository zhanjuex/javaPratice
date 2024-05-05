import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CreateThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CreateThread1 thread1 = new CreateThread1();
        thread1.start();

        CreateThread2 thread2 = new CreateThread2();
        thread2.run();
        Thread thread2_2 = new Thread(thread2);
        thread2_2.start();

        CreateThread3 thread3 = new CreateThread3();
        FutureTask<String> futureTask = new FutureTask<>(thread3);
        Thread thread3_3 = new Thread(futureTask);
        thread3_3.start();
        System.out.println(futureTask.get());

        /**
         * Result:
         *
         * CreateThread1 12
         * 继承Thread
         * CreateThread2 1
         * 实现Runnable
         * CreateThread2 13
         * 实现Runnable
         * CreateThread3 14
         * 实现Callable
         */
    }

}

class CreateThread1 extends Thread {
    public void run() {
        System.out.println("CreateThread1 " + Thread.currentThread().getId());
        System.out.println("继承Thread");
    }
}

class CreateThread2 implements Runnable {
    public void run() {
        System.out.println("CreateThread2 " + Thread.currentThread().getId());
        System.out.println("实现Runnable");
    }
}

class CreateThread3 implements Callable<String> {
    public String call() {
        System.out.println("CreateThread3 " + Thread.currentThread().getId());
        return "实现Callable";
    }
}