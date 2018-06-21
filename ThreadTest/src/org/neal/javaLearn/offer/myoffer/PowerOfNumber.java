package org.neal.javaLearn.offer.myoffer;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class PowerOfNumber {
    public double power(float base, int exponent) {
        double result = 0.0;

        if (equal(base, 0.0) && exponent < 0) {
            throw new RuntimeException("0的负数次幂没有意义");
        }

        //任何数的0次幂都为1
        if(exponent==0){
            return 1;
        }

        if (exponent < 0) {
            return powerOfNumber(base, -exponent);
        }else{
            return powerOfNumber(base,exponent);
        }

    }

    private double powerOfNumber(float base, int exponent) {
        double result = 1.0;
        for (int i = 1; i <= exponent; i++) {
            result = base * result;
        }
        return result;
    }

    //对计算进行优化  使用递归
    private double powerOfNumber2(float base,int exponent){
        if(exponent==0){
            return 0;
        }

        if(exponent == 1){
            return 1;
        }

        double result = powerOfNumber2(base,exponent>>1);
        result *= result;

        if((exponent & 1) == 1){
            result = result * base;
        }

        return result;
    }

    private boolean equal(float base, double v) {
        if (Math.abs(base - v) < 0.00000000001) {
            return true;
        }
        return false;
    }
}
