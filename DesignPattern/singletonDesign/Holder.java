public class Holder {

    private Holder() {
        System.out.println("Holder " + Thread.currentThread().getName() + " ok!");

    };
    public static Holder getInstance() {
        return InnerClass.holder;
    }

    private static class InnerClass {
        private static final Holder holder = new Holder();
    }
}
