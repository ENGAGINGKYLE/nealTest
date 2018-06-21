package org.neal.javaLearn.offer.myoffer;

/**
 * 懒汉式  线程安全
 */
public class SingletonPattern4 {

    private static SingletonPattern4 myInstance = null;

    private SingletonPattern4() {
    }

    public synchronized static SingletonPattern4 getMyInstance() {
        if (myInstance == null) {
            myInstance = new SingletonPattern4();
        }
        return myInstance;
    }
}
