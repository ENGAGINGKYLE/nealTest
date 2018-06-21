package org.neal.javaLearn.offer.jianzhiOffer;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class FindInTwoDimensionalArray {
    /**
     * 思路 矩阵是有序的，从右上角来看，向左数字递减，向下数字递增，
     * 因此从右上角开始查找，当要查找数字比左下角数字大时。下移
     * 要查找数字比左上角数字小时，左移
     */
    public boolean Find(int[][] array, int target) {
        int len = array.length - 1;
        int i = 0;
        while ((len >= 0) && (i < array[0].length)) {
            if (array[len][i] > target) {
                len--;
            } else if (array[len][i] < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }

}
