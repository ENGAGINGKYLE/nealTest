package org.neal.javaLearn.offer.jianzhiOffer;

//给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。

public class PowerOfNumber {
    /**
     * 思路1：本题主要考虑边界问题,全面不够高效的解法，
     * 注意：由于计算机表示小数（包括float和double型小数）都有误差，
     * 我们不能直接用==判断两个小数是否相等，如果两个小数的差的绝对值很小，
     * 比如小于0.0000001，就可以认为他们相等
     */
    public double Power(double base, int exponent) {
        double res = 0.0;
        if (equal(base, 0.0) && exponent < 0) {
            throw new RuntimeException("0的负数次幂没有意义");
        }
        // 这里定义0的0次方为1
        if (exponent == 0) {
            return 1.0;
        }
        if (exponent < 0) {
            res = powerWithExponent(1.0 / base, -exponent);
        } else {
            res = powerWithExponent(base, exponent);
        }
        return res;
    }

    private double powerWithExponent(double base, int exponent) {
        double res = 1.0;
        for (int i = 1; i <= exponent; i++) {
            res = res * base;
        }
        return res;
    }

    // 判断double类型的数据
    private boolean equal(double num1, double num2) {
        if (Math.abs(num1 - num2) < 0.0000001) {
            return true;
        }
        return false;
    }

    /**
     * 思路2：n为偶数时：a^n=a^n/2 * a^n/2;
     * n为奇数，a^n=（a^（n-1）/2）* （a^（n-1/2））* a
     * 所以对乘法处进行优化，如果是32次方，等于16次方*16次方
     *  private double powerWithExponent(double base, int exponent) {
     *         if(exponent==0){
     *             return 1;
     *         }
     *
     *         if(exponent==1){
     *             return base;
     *         }
     *
     *        double result = powerWithExponent(base,exponent>>1);//每次除以2
     *        result*=result;//最后相乘，如果是奇数，还要乘一个
     *
     *         //如果是奇数次方的情况，最终除2余1要与base相乘
     *         if((exponent & 0x1)==1){
     *             result *= base;
     *         }
     *         return result;
     *     }
     *
     */

}
