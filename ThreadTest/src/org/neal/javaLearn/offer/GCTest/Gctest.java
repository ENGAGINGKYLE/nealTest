package org.neal.javaLearn.offer.GCTest;

public class Gctest {
    private Object instance = null;
    private static final int _10M = 10 * 1 << 20;
    // 一个对象占10M，方便在GC日志中看出是否被回收
    private byte[] bigSize = new byte[_10M];

    public static void main(String[] args) {
        Gctest objA = new Gctest();
        Gctest objB = new Gctest();

        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        System.gc();
    }
}