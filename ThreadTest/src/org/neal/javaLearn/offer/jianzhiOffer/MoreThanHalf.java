package org.neal.javaLearn.offer.jianzhiOffer;

//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
// 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次 ，
// 超过数组长度的一半，因此输出2。如果不存在则输出0。
public class MoreThanHalf {
    /**
     * 思路：O(n)的思想是，定义两个变量result 和count，每次循环时，如果array[i]的值等于result ，
     * 则count自增，如不等并且count>0，则count自减，count==0，
     * 重新对temp赋值为当前array[i]，count赋值为1。
     * 如存在大于一半的数，直接返回result 就是了，但测试数据中有不存在的情况，
     * 所以最后又来了一遍校验，检查当前result 值是否出现过一半以上。
     */
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }

        int result = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == result) {
                count++;
            } else if (count > 0) {
                count--;
            } else if (count == 0) {
                result = array[i];
                count = 1;
            }
        }
        //验证
        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == result)
                count++;
        }
        return count > array.length / 2 ? result : 0;
    }
}
