package org.neal.javaLearn.offer.Singleton;

//饿汉模式：线程安全，耗费资源。
//属性实例化对象
public class HugerSingletonTest {

    //该对象的引用不可修改
    private static final HugerSingletonTest ourInstance = new HugerSingletonTest();

    public static HugerSingletonTest getInstance() {
        return ourInstance;
    }

    private HugerSingletonTest() {

    }

}

//在静态代码块中实例化对象
//public class Singleton {
//    private static Singleton ourInstance;
//
//    static {
//        ourInstance = new Singleton();
//    }
//
//    public static Singleton getInstance() {
//        return ourInstance;
//    }
//
//    private Singleton() {
//    }
//}