package org.neal.javaLearn.offer.myoffer;

import java.util.Scanner;

/**
 * 思路：使用暴力遍历  对所有序列的数组进行九宫格规则检查
 */

public class Nine {

    private static int count = 0;  //记录printArray方法被调用的次数

    public static void main(String[] args) {

        int[] array = new int[9];
        Scanner scanner = new Scanner(System.in);

        System.out.println("print...");
        for (int i = 0; i < 9; i++) {
            array[i] = scanner.nextInt();
        }

        permuteAndPrint(array, 0);
        //如果printArray方法没有被调用则说明无解
        if (count == 0) {
            System.out.println("无解");
        }

    }

    public static void printArray(int[] arr) {

        int[][] nine = new int[3][3];

        for (int i = 0; i < 9; i++) {
            nine[i / 3][i % 3] = arr[i];
        }

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                System.out.print(nine[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("===========");

        count++;
    }

    /**
     * 求数组中序列的全排列
     * 并且以九宫格形式输出符合九宫格规则的数组
     *
     * @param arr
     * @param start
     */
    private static void permuteAndPrint(int[] arr, int start) {
        int[] temp = arr;
        if (start == arr.length) {
            //检查是否符合九宫格规则并输出
            if (check(arr)) {
                printArray(arr);
            }
        } else {
            for (int i = start; i < arr.length; i++) {
                //交换两个数
                swap(arr, start, i);
                //进行一次新的全排列
                permuteAndPrint(arr, start + 1);
                //复原数组
                swap(arr, start, i);
            }
        }

    }


    /**
     * 检查数组是否符合九宫格规则
     *
     * @param arr
     * @return
     */
    private static boolean check(int[] arr) {

        int sum = arr[0] + arr[1] + arr[2];
        //检查行相等
        for (int i = 3; i <= 6; i += 3) {
            if (sum != arr[i] + arr[i + 1] + arr[i + 2])
                return false;
        }
        //检查列相等
        for (int i = 0; i < 3; i++) {
            if (sum != arr[i] + arr[i + 3] + arr[i + 6])
                return false;
        }

        //检查对角线相等
        if (sum != arr[0] + arr[4] + arr[8])
            return false;
        if (sum != arr[2] + arr[4] + arr[6])
            return false;

        return true;
    }

    /**
     * 交换数组中下标对应的两个数
     *
     * @param arr
     * @param start
     * @param i
     */
    private static void swap(int[] arr, int start, int i) {
        int temp = arr[start];
        arr[start] = arr[i];
        arr[i] = temp;
    }


}


