package org.neal.javaLearn.offer.StaticKeyWordTest;
//
//static是java中非常重要的一个关键字，而且它的用法也很丰富，主要有四种用法：
//
//    1.用来修饰成员变量：将其变为类的成员，从而实现所有对象对于该成员的共享，全局唯一；
//    2.用来修饰成员方法：将其变为类方法，可以直接使用“类名.方法名”的方式调用，常用于工具类，不必new一个新的对象来调用方法；
//    3.静态块用法：将多个类成员放在一起初始化，使得程序更加规整，其中理解对象的初始化过程非常关键,
//                static修饰的类成员只会初始化一次，并且在第一次使用该类的时候首先执行静态代码块；
//    4.静态导包用法：将类的方法直接导入到当前类中，在与当前类中的方法不冲突的情况下，从而直接使用“方法名”即可调用类方法，
//                  相当于使用当前类中的方法，更加方便。

public class Person {
    //static关键字修饰的变量全局唯一，交由类来进行管理
    private static int count = 0;
    int id;
    String name;
    int age;

    public Person() {
        id = ++count;
    }

    public int getCount(){
        return count;
    }

    public String toString() {
        return "Id:" + id + ", Name:" + name + ", Age:" + age;
    }

    public static void main(String[] args) {
        Person p1 = new Person();
        p1.name = "zhangsan";
        p1.age = 10;
        Person p2 = new Person();
        p2.name = "lisi";
        p2.age = 12;
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p1.getCount());
        System.out.println(p2.getCount());
    }
    /**Output
     * Id:1, Name:zhangsan, Age:10
     * Id:2, Name:lisi, Age:12
     * 2
     * 2
     */
}