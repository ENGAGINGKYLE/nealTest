package org.neal.javaLearn.offer.StaticKeyWordTest;

class BookA {
    public BookA(String msg) {
        System.out.println(msg);
    }
}

public class Teacher {
    BookA b1 = new BookA("b1被初始化。。。");
    static BookA b2 = new BookA("b2被初始化。。。");
    public Teacher(String msg) {

        System.out.println(msg);
    }

    BookA b3 = new BookA("b3被初始化。。。");
    static BookA b4 = new BookA("b4被初始化。。。");

    public static void function() {
        System.out.println("function方法运行中。。。");
    }

    public static void main(String[] args) {
        Teacher.function();
        System.out.println("********************");
        Teacher t1 = new Teacher("t1被初始化。。。");
    }
}
