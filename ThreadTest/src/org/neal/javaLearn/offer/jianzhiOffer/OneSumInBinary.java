package org.neal.javaLearn.offer.jianzhiOffer;

//二进制中1的个数
//输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
public class OneSumInBinary {
    //最差的解法：因为要考虑负数的问题，若是负数,因为要保证一直输负数，
    // 多以第一位一直为1，最后会变成0XFFFFFFFF,造成死循环
    public int NumberOf1(int n) {
        int count = 0;
        int flag = 1;
        while (n != 0) {
            if ((n & 1) != 0) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    //改进的解法：
    public int  NumberOf12(int n) {
        int count= 0;
        int flag = 1;
        while (flag != 0){
            if ((n & flag) != 0){
                count++;
            }
            flag  = flag << 1;
        }
        return count;
    }

    //最精妙的解法
    public int NumberOf13(int n) {
        int count = 0;
        while(n!= 0){
            count++;
            n = n & (n - 1);//每一次将最后一个1变成0
        }
        return count;
    }

}
