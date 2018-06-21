package org.neal.javaLearn.offer.myoffer;

/**
 * 懒汉式
 * 线程安全
 * 双重锁
 * 对于singleton = new Singleton()，创建一个对象不是原子操作  有三步：
 *
 *      •1>给 singleton 分配内存
 *      •2>调用 Singleton 的构造函数来初始化成员变量，形成实例
 *      •3>将singleton对象指向分配的内存空间（执行完这步 singleton才是非 null 了）
 */
public class SingletonPattern5 {

    //此处加上volatile关键字  防止JVM进行指令重排序
    private volatile static SingletonPattern5 myInstance;

    private SingletonPattern5() {
    }

    public synchronized static SingletonPattern5 getMyInstance() {

        if (myInstance == null) {//此处可能会有多个进程进入 所以给下方的代码块加锁  并在此对对象进行空判断
            synchronized (SingletonPattern5.class) {
                if (myInstance == null) {
                    myInstance = new SingletonPattern5();
                }
            }
        }
        return myInstance;
    }
}
