package org.neal.javaLearn.offer.myoffer;

import java.util.Arrays;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class MiniNumber {
    public static int findMinNumber(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }

        int low = 0;
        int up = arr.length-1;
        int mid = low;

        while(arr[low] >= arr[up]){
            if (up - low == 1) {//当两个指针相邻时  找到最小值  即右边序列的第一个值
                mid = up;
                break;
            }

            if(arr[low]==arr[up]&&arr[mid]==arr[low]){
                return minInOrder(arr);
            }

            mid = (low+up)/2;

            if(arr[mid] >= arr[low]){//如果mid处的值大于等于low处的值  说明mid仍然处于左边序列内  此时缩短左边序列长度
                low = mid;
            } else if (arr[mid] <= arr[up]) {//如果mid处的值小于等于up处的值  说明mid处于右边序列内  此时缩短右边序列长度
                up = mid;
            }

        }
        return arr[mid];

    }

    private static int minInOrder(int[] arr) {
        int mid = arr[0];
        for(int i=1; i<=arr.length-1; i++){
            if(arr[i] < mid){
                mid = arr[i];
            }
        }
        return mid;
    }

    public static void main(String[] args){
        int[] arr = {3,4,5,6,1,2};
        System.out.println(findMinNumber(arr));

    }
}
