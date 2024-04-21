// import java.util.concurrent.atomic.AtomicInteger;
//
// public class PrintNumber {
//     public static void main(String[] args) {
//         Object o1 = new Object();
//         Object o2 = new Object();
//         Object o3 = new Object();
//         AtomicInteger i = new AtomicInteger();
//         new Thread(() -> {
//             while (true) {
//                 synchronized (o1) {
//                     if ((i.get() % 3) == 0) {
//                         if (i.get() <= 100) {
//                             System.out.println(Thread.currentThread().getId() + " " + i.toString());
//                             i.getAndIncrement();
//                         } else {
//                             break;
//                         }
//                     }
//                 }
//             }
//         }).start();
//
//         new Thread(() -> {
//             while (true) {
//                 synchronized (o2) {
//                     if ((i.get() % 3) == 1) {
//                         if (i.get() <= 100) {
//                             System.out.println(Thread.currentThread().getId() + " " + i.toString());
//                             i.getAndIncrement();
//                         } else {
//                             break;
//                         }
//                     }
//                 }
//             }
//         }).start();
//
//         new Thread(() -> {
//             while (true) {
//                 if ((i.get() % 3) == 2) {
//                     if (i.get() <= 100) {
//                         System.out.println(Thread.currentThread().getId() + " " + i.toString());
//                         i.getAndIncrement();
//                     } else {
//                         break;
//                     }
//                 }
//             }
//         }).start();
//
//     }
// }
//
//

/**
 * 打印100
 */
public class PrintNumber {
    private static final Object lock = new Object();
    private static int number = 1;
    private static final int MAX_NUMBER = 100;
    private static boolean finished = false;

    public static void main(String[] args) {
        Thread t1 = new Thread(new Printer(1), "Thread 1");
        Thread t2 = new Thread(new Printer(2), "Thread 2");
        Thread t3 = new Thread(new Printer(0), "Thread 3");

        t1.start();
        t3.start();
        t2.start();

    }

    static class Printer implements Runnable {
        private final int remainder;

        public Printer(int remainder) {
            this.remainder = remainder;
        }

        @Override
        public void run() {
            while (!finished) {
                synchronized (lock) {
                    // 如果不是该线程打印的数字，则等待
                    while (!finished && number % 3 != remainder) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    // 打印数字
                    if (!finished && number <= MAX_NUMBER) {
                        System.out.println(Thread.currentThread().getName() + ": " + number);
                        number++;

                        // 唤醒其他线程
                        lock.notifyAll();
                    }

                    // 打印完最后一个数字后，设置标志位并退出
                    if (number > MAX_NUMBER) {
                        finished = true;
                    }
                }
            }
        }
    }
}
