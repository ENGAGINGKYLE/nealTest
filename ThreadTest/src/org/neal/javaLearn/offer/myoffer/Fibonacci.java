package org.neal.javaLearn.offer.myoffer;

/**
 * 斐波那契数列
 */
public class Fibonacci {
    //递归实现  简洁但效率不高
    public int fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    //循环 O(n)
    public int fibnacci2(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        int preNum = 0, secNum = 1, sum = 0;

        for (int i = 2; i < n; i++) {
            sum = preNum + secNum;
            preNum = secNum;
            secNum = sum;
        }

        return sum;

    }


    //扩展1：跳台阶 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
    public int steps(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        return steps(n - 1) + steps(n - 2);
    }

    //扩展2：变态跳台阶  一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
    public int hentaiSteps(int n){

        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        return hentaiSteps(n-1)*2;
    }
}
