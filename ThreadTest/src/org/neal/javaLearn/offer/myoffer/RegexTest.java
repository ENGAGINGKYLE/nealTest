package org.neal.javaLearn.offer.myoffer;

import java.util.Scanner;

public class RegexTest {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("print username : ");

        String s = scanner.nextLine();

        String regex = "[a-zA-z_0-9]{3,}@([a-zA-Z]+|\\d+)(\\.[a-zA-Z]+)+";

        boolean flag = s.matches(regex);

        System.out.println(flag);
    }

}
