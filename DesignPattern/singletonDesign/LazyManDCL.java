public class LazyManDCL {
    private LazyManDCL() {
        System.out.println("LazyManDCL " + Thread.currentThread().getName() + " ok!");

    };
    private volatile static LazyManDCL lazyManDCL;

    public static LazyManDCL getInstance() {

        /**
         * 1.分配内存空间
         * 2、执行构造方法，初始化对象
         * 3、把这个对象指向这个空间
         * 123
         * 132 A
         * B // 此时lazyMan还没有完成构造, 返回不安全对象
         */

        // 双重检查锁
        // 第一个判断防止线程空等，提高cpu利用率
        if (lazyManDCL == null) {
            synchronized(LazyManDCL.class) {
                if (lazyManDCL == null)
                    lazyManDCL =  new LazyManDCL();
            }
        }
        return lazyManDCL;
    }
}


