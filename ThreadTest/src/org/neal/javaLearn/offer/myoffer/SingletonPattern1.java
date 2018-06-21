package org.neal.javaLearn.offer.myoffer;

/**
 * Singleton模式
 */

public class SingletonPattern1 {
    //饿汉式（创建类的实例时就创建对象）  属性实例化对象  线程安全
    private SingletonPattern1() {

    }

    private static final SingletonPattern1 myInstance = new SingletonPattern1();

    public static SingletonPattern1 getInstance() {

        System.out.println();
        return myInstance;
    }

}
