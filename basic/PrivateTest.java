public interface PrivateTest {
    default void logging() {System.out.println("1");}
    abstract void logging1();

    public static void main(String[] args) {
        // PrivateTest privateTest = new PrivateTest() {
        // };
        // privateTest.logging();
    }
}

