public class LazyMan {
    private LazyMan() {
        System.out.println("Lazy " + Thread.currentThread().getName() + " ok!");
    };
    private static LazyMan lazyMan;

    public static LazyMan getInstance() {
        if (lazyMan == null) {
            lazyMan = new LazyMan();
        }
        return lazyMan;
    }
}

