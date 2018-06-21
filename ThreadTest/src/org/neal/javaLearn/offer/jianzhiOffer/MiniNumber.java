package org.neal.javaLearn.offer.jianzhiOffer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class MiniNumber {
    /**
     * 传进去旋转数组，注意旋转数组的特性： 1.包含两个有序序列 2.最小数一定位于第二个序列的开头 3.前序列的值都>=后序列的值
     */

    // 用到了快速排序的快速定位范围的思想，
    public static int minNumberInRotateArray(int[] array) {

        if (array == null || array.length == 0) {
            return 0;
        }
        int low = 0;//指向第一个
        int up = array.length - 1;//指向最后一个
        int mid = low;

        // 当low和up两个指针相邻时候，就找到了最小值，也就是
        // 右边序列的第一个值

        while (array[low] >= array[up]) {
            if (up - low == 1) {
                mid = up;
                break;
            }
            // 如果low、up、mid下标所指的值恰巧相等
            // 如：{0,1,1,1,1}的旋转数组{1,1,1,0,1}
            if (array[low] == array[up] && array[mid] == array[low])
                return MinInOrder(array);
            mid = (low + up) / 2;
            // 这种情况，array[mid]仍然在左边序列中
            if (array[mid] >= array[low])
                low = mid;// 注意，不能写成low=mid+1；
                // 要是这种情况，array[mid]仍然在右边序列中
            else if (array[mid] <= array[up])
                up = mid;
        }

        return array[mid];

    }

    private static int MinInOrder(int[] array) {
        // TODO Auto-generated method stub
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];

            }
        }
        return min;
    }
    public static void main(String[] args){
        int[] arr = {3,4,5,6,1,2};
        System.out.println(minNumberInRotateArray(arr));

    }
}
