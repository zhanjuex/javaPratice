public class HungryMan {

    // 一上来就把所有资源都加载了
    private HungryMan(){
        System.out.println("Hungry " + Thread.currentThread().getName() + " ok!");
    }
    private final static HungryMan hungryMan = new HungryMan();

    public static HungryMan getInstance(){
        return hungryMan;
    }
}


