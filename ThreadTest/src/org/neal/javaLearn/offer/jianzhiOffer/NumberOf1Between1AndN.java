package org.neal.javaLearn.offer.jianzhiOffer;

/**
 * 例如n=13的整数中1出现的次数，1~13中包含1的数字有1、10、11、12、13因此共出现6次
 * <p>
 * 1、  如果第i位（自右至左，从1开始标号）上的数字为0，
 * 则第i位可能出现1的次数由更高位决定（若没有高位，视高位为0），
 * 等于更高位数字 * 当前位数的权重10^(i-1)。
 * <p>
 * 2、  如果第i位上的数字为1，则第i位上可能出现1的次数不仅受更高位影响，
 * 还受低位影响（若没有低位，视低位为0），
 * 等于更高位数字 * 当前位数的权重10^(i-1)+（低位数字+1）。
 * <p>
 * 3、  如果第i位上的数字大于1，则第i位上可能出现1的次数仅由更高位决定（若没有高位，视高位为0），
 * 等于（更高位数字+1） * 当前位数的权重10^(i-1)。
 */

public class NumberOf1Between1AndN {

    public static int NumberOf1Between1AndN_Solution(int n) {
        return NumberOf1Between1AndN_Solution2(n, 1);
    }

    private static int NumberOf1Between1AndN_Solution2(int n, int x) {

        if(n<0||x>9||x<0) {
            return 0;
        }

        int count = 0;
        int i = 1;
        int high,low,cur,temp;
        high = n;

        while(high != 0){
            high = n/(int)Math.pow(10,i);//获取第i位 的高位数
            temp = n%(int)Math.pow(10,i);
            low = temp%(int)Math.pow(10,i-1);//获取第i位的低位数
            cur = temp/(int)Math.pow(10,i-1);//获取第i位

            if(cur < x){
                count += high * (int)Math.pow(10,i-1);
            }else if(cur > x){
                count += (high + 1) * (int)Math.pow(10,i-1);
            }else{
                count += high * (int)Math.pow(10,i-1) + low + 1;
            }

            i++;
        }
        return count;
    }

    public static void main(String[] args) {
        int a = 123456;

        System.out.println(NumberOf1Between1AndN_Solution(2593));
        System.out.println((int)Math.pow(10,3));
    }
}
