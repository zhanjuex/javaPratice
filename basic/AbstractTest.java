//
// /**
//  * Animal 动物抽象类 抽象类不能创建实例，只能当成父类来被继承。
//  * 1、抽象类必须使用abstract修饰符来修饰，
//  * 抽象方法也必须使用abstract修饰符来修饰，
//  * 抽象方法不能有方法体。
//  * 2、抽象类不能被实例化，
//  * 无法使用new关键字来调用抽象类的构造器创建抽象类的实例。
//  * 3、抽象类可以包含成员变量、
//  * 方法（普通方法和抽象方法都可以）、
//  * 构造器、初始化块、
//  * 内部类（接 口、枚举）5种成分。
//  * 4、抽象类的构造器不能用于创建实例，主要是用于被其子类调用。
//  * 5、抽象类中不一定包含抽象方法，但是有抽象方法的类必定是抽象类
//  * 6、abstract static不能同时修饰一个方法  （abstract方法没有方法体不能直接调用，static方法可以直接调用，冲突）
//  */
// public abstract class AbstractTest {
//     // 成员变量
//     protected int weight = 0;
//
//     static {
//         System.out.println("static初始化块");
//     }
//
//     {
//         System.out.println("初始化块");
//     }
//
//     // 构造器
//     public AbstractTest() {
//         System.out.println("Animal 的无参构造器");
//     }
//
//     public AbstractTest(int weight) {
//         this.weight = weight;
//         System.out.println("Animal 的有参构造器");
//     }
//
//     // 定义一个普通方法 休息
//     public void sleep() {
//         System.out.println("休息");
//     }
//
//     // //抽象方法没有方法体
//     // public abstract void running();
//     //
//     // public abstract String say(String str);
//
//     public static void main(String[] args) {
//         AbstractTest abstractTest = new AbstractTest() {};
//         new AbstractTest() {};
//     }
// }

public abstract class AbstractTest {
    String name;
    String color;

    public AbstractTest(String name,String color){
        this.name = name;
        this.color = color;
    }
    // public abstract void run();

    static class a {
        {
            System.out.println("静态内部类");
        }
    }
}

class Test implements A, B{
    public static void main(String[] args) {
        // 匿名内部类实现子类才能new
        AbstractTest a = new AbstractTest("1", "2"){};
        // AbstractTest b = new AbstractTest("1", "2");

        // 多实现矛盾如何解决，会显示额外信息。
        System.out.println(B.a);

        final String s = new String("123");


        // 浅拷贝实现
        // AbstractTest b = Object.clone(a);

    }
}

// 多实现矛盾如何解决，会显示额外信息。
interface A {
    final int a = 0;
    int b = 0;
    default void logging() {}

}

interface B {
    final int a = 1;
}