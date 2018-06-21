package org.neal.javaLearn.offer.myoffer;
/**
 *
 利用二维数组由上到下，由左到右递增的规律，
 那么选取右上角或者左下角的元素a[row] [col]与target进行比较，
 当元素a[row] [col]大于target时，那么target必定在元素a所在行的左边,
 即col--；
 当元素a[row][col]小于target时，那么target必定在元素a所在列的下边,
 即row++；
 即元素a[row][column]是一个中间值  比它大 向下走  比它小 向左走
 *
 */
public class FindInTwoDimensionalArray {
    public static boolean findMin(int[][] arr, int target) {
        if(arr == null){
            return false;
        }

        int row = 0;
        int column = arr[0].length - 1;

        while(row < arr.length && column >= 0){
            if(arr[row][column] == target){
                return true;
            }

            if(arr[row][column] > target){
                column--;
            }else{
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[][] arr = {{1,2,3,4},{2,3,4,5},{3,4,7,8}};
        System.out.println(findMin(arr,5));
    }
}
