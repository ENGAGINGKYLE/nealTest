package org.neal.javaLearn.offer.TestString;

public class TestString {
    public static void main(String[] args){

        StringBuffer s = new StringBuffer("abc");
        System.out.println(s.getClass().getName());
        s = s.append(1);
        System.out.println(s.getClass().getName());

    }
}
