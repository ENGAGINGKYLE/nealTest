package org.neal.javaLearn.offer.jianzhiOffer;
//调整数组顺序使奇数位于偶数前面
//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
// 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
// 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
public class ReOrderArray {
    public void reOrderArray(int [] array) {
        //注释的部分使用快速排序的算法，很明显快速排序是不稳定的，这里需要用归并排序
        /*
        if(array.length == 0){
            return;
        }
        int high = array.length - 1;
        int low = 0;
        while(low < high){
            while(low < high && array[low] % 2 == 1){
                low ++;
            }
            while(low < high && array[high] % 2 == 0){
                high --;
            }
            int temp = array[low];
            array[low] = array[high];
            array[high] = temp;
        }*/

        //用用归并排序的思想，因为归并排序是稳定的
        int length = array.length;
        if(length == 0){
            return;
        }
        int[] des = new int[length];
        MergeMethod(array, des, 0,length - 1);
    }
    public void MergeMethod(int[] array, int [] des, int start, int end){
        if(start < end){
            int mid = (start + end) / 2;
            MergeMethod(array, des, start, mid);
            MergeMethod(array, des, mid + 1, end);
            Merge(array, des, start, mid, end);
        }
    }

    public void Merge(int[] array, int[] des, int start, int mid, int end){
        int i = start;
        int j = mid + 1;
        int k = start;
        while(i <= mid && array[i] % 2 == 1){
            des[k++] = array[i++];
        }
        while(j <= end && array[j] % 2 == 1){
            des[k++] = array[j++];
        }
        while(i <= mid){
            des[k++] = array[i++];
        }
        while(j <= end){
            des[k++] = array[j++];
        }

        for(int m = start; m <= end; m++){
            array[m] = des[m];
        }
    }
}
