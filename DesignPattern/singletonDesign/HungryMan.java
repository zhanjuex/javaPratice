public class HungryMan {

    // 一上来就把所有资源都加载了
    private HungryMan(){}
    private final static HungryMan hungryMan = new HungryMan();

    public static HungryMan newInstance(){
        return hungryMan;
    }
}
