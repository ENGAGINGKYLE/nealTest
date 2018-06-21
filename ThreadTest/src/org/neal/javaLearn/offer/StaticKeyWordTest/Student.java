package org.neal.javaLearn.offer.StaticKeyWordTest;

class Book {
    public Book(String msg) {
        System.out.println(msg);
    }
}

public class Student {

    Book book1 = new Book("book1成员变量初始化");
    static Book book2 = new Book("static成员book2成员变量初始化");

    public Student(String msg) {
        System.out.println(msg);
    }

    Book book3 = new Book("book3成员变量初始化");
    static Book book4 = new Book("static成员book4成员变量初始化");

    public static void main(String[] args) {
        Student p1 = new Student("p1初始化");
    }
    /**Output
     * static成员book2成员变量初始化
     * static成员book4成员变量初始化
     * book1成员变量初始化
     * book3成员变量初始化
     * p1初始化
     *///~
}

