package org.neal.javaLearn.offer.myoffer;

/**
 * 懒汉式
 * 需要才去创建对象
 * 如果两个线程同时调用getMyInstance()  会创建两个对象
 * 所以非线程安全
 */
public class SingletonPattern3 {

    private static SingletonPattern3 myInstance = null;

    public static SingletonPattern3 getMyInstance() {
        if (myInstance == null) {
            myInstance = new SingletonPattern3();
        }
        return myInstance;
    }

    private SingletonPattern3() {
    }
}
