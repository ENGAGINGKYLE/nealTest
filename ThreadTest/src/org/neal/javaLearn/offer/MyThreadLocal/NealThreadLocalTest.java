package org.neal.javaLearn.offer.MyThreadLocal;

import java.util.Random;

public class NealThreadLocalTest implements Runnable{
    private final static ThreadLocal meLocal = new ThreadLocal();

    public static void main(String[] args) {
        NealThreadLocalTest theadLocalTest = new NealThreadLocalTest();
        Thread t1 = new Thread(theadLocalTest, "a");
        Thread t2 = new Thread(theadLocalTest, "b");
        t1.start();
        t2.start();
    }
    @Override
    public void run() {

        accessMe();
    }

    private void accessMe() {

        String currentThreadName = Thread.currentThread().getName();
        System.out.println("current thread :"+currentThreadName+" is running");
        Random random = new Random();
        int range = random.nextInt(100);
        System.out.println("current thread "+currentThreadName+" set age to "+range);
        Me me = getMe();
        me.setAge(range);
        System.out.println("current thread "+currentThreadName+" first age is "+me.getAge());

        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("current thread "+currentThreadName+" second age is "+me.getAge());
    }

    protected Me getMe(){
        Me me = (Me)meLocal.get();
        if(me == null){
            me = new Me();
            meLocal.set(me);
        }
        return me;
    }
}
