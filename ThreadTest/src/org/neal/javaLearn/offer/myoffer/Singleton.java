package org.neal.javaLearn.offer.myoffer;

/**
 * 枚举
 * 可以防止用户通过反射机制调用私有构造器
 * 也可以防止用户通过反序列化创建新对象
 * 但是枚举中的其他方法的线程安全要由程序员自己负责
 */
public enum Singleton {
    INSTANCE;

    public void whateverMethod(){}
}
