package org.neal.javaLearn.offer.MyThreadLocal;

import java.util.Random;

public class ThreadTest implements Runnable {
    private final static ThreadLocal myLocalThread = new ThreadLocal();
    public static void main(String[] args){
        ThreadTest t = new ThreadTest();
        Thread t1 = new Thread(t,"a");
        Thread t2 = new Thread(t,"b");
        t1.start();
        t2.start();

    }
    @Override
    public void run() {
        accessMe();
    }

    private void accessMe() {
        String currentName = Thread.currentThread().getName();
        System.out.println(currentName + " is running...");
        Random random = new Random();
        int age = random.nextInt(100);
        System.out.println(currentName + " set first age :" + age);
        Me me = getMe();
        me.setAge(age);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(currentName + " set second age :"+ age);
    }

    private Me getMe() {
        Me me = (Me)myLocalThread.get();
        if(me == null){
            me = new Me();
            myLocalThread.set(me);
        }
        return me;
    }
}
