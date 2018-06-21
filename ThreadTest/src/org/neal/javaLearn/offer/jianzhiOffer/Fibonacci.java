package org.neal.javaLearn.offer.jianzhiOffer;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 */

//递归  效率不高
public class Fibonacci {
    public int FibonacciSolution(int n) {
        if(n<=0)
            return 0;
        if(n==1)
            return 1;
        return FibonacciSolution(n-1) + FibonacciSolution(n-2);
    }
}

//循环  O(n)

/**
 * public class Solution {
 *     public int Fibonacci(int n) {
 *         int preNum=1;
 *         int prePreNum=0;
 *         int result=0;
 *         if(n==0)
 *             return 0;
 *         if(n==1)
 *             return 1;
 *         for(int i=2;i<=n;i++){
 *             result=preNum+prePreNum;
 *             prePreNum=preNum;
 *             preNum=result;
 *         }
 *         return result;
 *
 *     }
 * }
 */

//扩展1 ：跳台阶 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
/**
 * 斐波拉契数序列，初始条件n=1:只能一种方法，n=2:两种
 * 对于第n个台阶来说，只能从n-1或者n-2的台阶跳上来，所以
 * F(n) = F(n-1) + F(n-2)
 */

//扩展2： 变态跳台阶  一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
//                   求该青蛙跳上一个n级的台阶总共有多少种跳法。
/**
 * 因为n级台阶，第一步有n种跳法：跳1级、跳2级、到跳n级
 * 跳1级，剩下n-1级，则剩下跳法是f(n-1)
 * 跳2级，剩下n-2级，则剩下跳法是f(n-2)
 * 所以f(n)=f(n-1)+f(n-2)+…+f(1)
 * 因为f(n-1)=f(n-2)+f(n-3)+…+f(1)
 * 所以f(n)=2*f(n-1)
 * 所以f(n)=2的(n-1)次幂
 *
 * public class Solution {
 *     public int JumpFloorII(int target) {
 *         if(target<=0)
 *             return 0;
 *         return 1<<(target-1);
 *     }
 * }
 */

