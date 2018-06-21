package org.neal.javaLearn.offer.myoffer;

/**
 * 静态内部类
 * 线程安全
 */
public class SingletonPattern6 {

    private static class SingletonPatternHolder{
        private static SingletonPattern6 myInstance = new SingletonPattern6();
    }

    private SingletonPattern6(){}

    public synchronized static SingletonPattern6 getMyInstance(){
        return SingletonPatternHolder.myInstance;
    }
}
