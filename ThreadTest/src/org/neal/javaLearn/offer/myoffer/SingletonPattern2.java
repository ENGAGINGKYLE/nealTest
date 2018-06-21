package org.neal.javaLearn.offer.myoffer;

/**
 * 在静态代码块实例化对象
 * 饿汉模式  无论是否会用到该实例  都会创建  消耗资源
 */


public class SingletonPattern2 {
    private static SingletonPattern2 myInstance;

    static {
        myInstance = new SingletonPattern2();
    }

    private SingletonPattern2() {
    }

    public static SingletonPattern2 getMyInstance() {
        return myInstance;
    }
}
