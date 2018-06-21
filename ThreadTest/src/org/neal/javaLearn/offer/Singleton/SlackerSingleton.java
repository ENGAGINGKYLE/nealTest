package org.neal.javaLearn.offer.Singleton;

//非线程安全
//如果有两个线程同时调用getInstance()方法，则会创建两个实例化对象。所以是非线程安全的
public class SlackerSingleton {

        private static SlackerSingleton ourInstance;

        public static SlackerSingleton getInstance() {
            if (null == ourInstance) {
                ourInstance = new SlackerSingleton();
            }
            return ourInstance;
        }

        private SlackerSingleton() {
        }

}

//线程安全：给方法加锁
//如果有多个线程调用getInstance()方法，当一个线程获取该方法，而其它线程必须等待，消耗资源。
/**
 * public class Singleton {
 *     private static Singleton ourInstance;
 *
 *     public synchronized static Singleton getInstance() {
 *         if (null == ourInstance) {
 *             ourInstance = new Singleton();
 *         }
 *         return ourInstance;
 *     }
 *
 *     private Singleton() {
 *     }
 * }
 */


//线程安全：双重检查锁（同步代码块）
/**
 * 为什么需要双重检查锁呢？因为第一次检查是确保之前是一个空对象，
 * 而非空对象就不需要同步了，空对象的线程然后进入同步代码块，
 * 如果不加第二次空对象检查，两个线程同时获取同步代码块，
 * 一个线程进入同步代码块，另一个线程就会等待，而这两个线程就会创建两个实例化对象，
 * 所以需要在线程进入同步代码块后再次进行空对象检查，才能确保只创建一个实例化对象
 */
/**
 *public class Singleton {
 *     private static Singleton ourInstance;
 *
 *     public synchronized static Singleton getInstance() {
 *         if (null == ourInstance) {
 *             synchronized (Singleton.class) {
 *                 if (null == ourInstance) {
 *                     ourInstance = new Singleton();
 *                 }
 *             }
 *         }
 *         return ourInstance;
 *     }
 *
 *     private Singleton() {
 *     }
 * }
 *
 */

//线程安全：静态内部类
//利用静态内部类，谋个线程在调用该方法时会创建一个实例化对象。

/***
 * public class Singleton {
 *     private static class SingletonHodler {
 *         private static Singleton ourInstance = new Singleton();
 *     }
 *
 *     public synchronized static Singleton getInstance() {
 *         return SingletonHodler.ourInstance;
 *     }
 *
 *     private Singleton() {
 *     }
 * }
 */

//线程安全：枚举
//枚举的方式是《Effective Java》书中提倡的方式，
// 它不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象，
// 但是在枚举中的其他任何方法的线程安全由程序员自己负责。
// 还有防止上面的通过反射机制调用私用构造器。不过，由于Java1.5中才加入enum特性，所以使用的人并不多
/**
 * enum SingletonTest {
 *     INSTANCE;
 *     public void whateverMethod() {
 *
 *     }
 * }
 */


//针对jvm的指令重排序

/**
 * public class Singleton {
 *     //volatile的作用是：保证可见性、禁止指令重排序，但不能保证原子性
 *     private volatile static Singleton ourInstance;
 *
 *     public synchronized static Singleton getInstance() {
 *         if (null == ourInstance) {
 *             synchronized (Singleton.class) {
 *                 if (null == ourInstance) {
 *                     ourInstance = new Singleton();
 *                 }
 *             }
 *         }
 *         return ourInstance;
 *     }
 *
 *     private Singleton() {
 *     }
 * }
 */
