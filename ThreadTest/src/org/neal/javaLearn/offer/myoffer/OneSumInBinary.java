package org.neal.javaLearn.offer.myoffer;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * << : 左移运算符，num << 1,相当于num乘以2
 * <p>
 * >> : 右移运算符，num >> 1,相当于num除以2
 * <p>
 * >>> : 无符号右移，忽略符号位，空位都以0补齐
 */
public class OneSumInBinary {
    //最差解法  对于负数会陷入死循环
    public int oneSum(int n) {
        int count = 0;
        int flag = 1;
        while (n != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    //改进
    public int oneSum1(int n) {
        int count;
        int flag = 1;

        if (n < 0) count = 1;
        else count = 0;

        while (n != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }

    //改进
    public int oneSum2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);  // 每次将n中的最后一个1置为0
        }
        return count;
    }
}
