package org.neal.javaLearn.offer.jianzhiOffer;

//输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。

import java.util.ArrayList;

public class FindMinNumber {
    /**
     * 思路1：
     * 经典常用的算法，快速排序的精髓利用快速排序划分的思想，
     * 每一次划分就会有一个数字位于以数组从小到达排列的的最终位置index；
     * 位于index左边的数字都小于index对应的值，右边都大于index指向的值；
     * 所以，当index > k-1时，表示k个最小数字一定在index的左边，此时，只需要对index的左边进行划分即可；
     * 当index < k - 1时，说明index及index左边数字还没能满足k个数字，需要继续对k右边进行划分；
     */
    public ArrayList GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList aList = new ArrayList();
        if(input.length == 0 || k > input.length || k <= 0)
            return aList;
        int low = 0;
        int high = input.length-1;
        int index = Partition(input,k,low,high);
        while(index != k-1){
            if (index > k-1) {
                high = index-1;
                index = Partition(input,k,low,high);
            }else{
                low = index+1;
                index = Partition(input,k,low,high);
            }
        }
        for (int i = 0; i < k; i++)
            aList.add(input[i]);
        return aList;
    }

    //快速排序的分段，小于某个数的放在左边，大于某个数的移到右边
    public int Partition(int[] input,int k,int low,int high){
        int pivotkey = input[k-1];
        swap(input,k-1,low);
        while(low < high){
            while(low < high && input[high] >= pivotkey)
                high--;
            swap(input,low,high);
            while(low < high && input[low] <= pivotkey)
                low++;
            swap(input,low,high);
        }
        return low;
    }


    private void swap(int[] input, int low, int high) {
        int temp = input[high];
        input[high] = input[low];
        input[low] = temp;
    }
}
/**
 *
 *思路2：可以先创建一个大小为k的数据容器来存储最小的k个数字，从输入的n个整数中一个一个读入放入该容器中，
 * 如果容器中的数字少于k个，按题目要求直接返回空；
 * 如果容器中已有k个数字，而数组中还有值未加入，此时就不能直接插入了，而需要替换容器中的值。按以下步骤进行插入：
 * 1、先找到容器中的最大值；
 * 2、将待查入值和最大值比较，如果待查入值大于容器中的最大值，则直接舍弃这个待查入值即可；
 *    如果待查入值小于容器中的最小值，则用这个待查入值替换掉容器中的最大值；
 * 3、重复上述步骤，容器中最后就是整个数组的最小k个数字。
 * -  对于这个容器的实现，我们可以使用最大堆的数据结构，最大堆中，根节点的值大于它的子树中的任意节点值。
 *    Java中的TreeSet类实现了红黑树的功能，它底层是通过TreeMap实现的，
 *    TreeSet中的数据会按照插入数据自动升序排列（按自然顺序）。因此我们直接将数据依次放入到TreeSet中，
 *    数组就会自动排序。
 *
 * public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
 *         ArrayList<Integer> leastNum = new ArrayList<Integer>();
 *         if (input == null || input.length < 1 || k < 1 || k > input.length)
 *             return leastNum;
 *         TreeSet<Integer> kSet = new TreeSet<Integer>();
 *         for (int i = 0; i < input.length; i++) {
 *             if (kSet.size() < k) {
 *                 kSet.add(input[i]);
 *             } else {
 *                 if (input[i] < kSet.last()) {
 *                     kSet.remove(kSet.last());
 *                     kSet.add(input[i]);
 *                 }
 *             }
 *         }
 *         Iterator<Integer> it = kSet.iterator();
 *         while (it.hasNext()) {
 *             leastNum.add(it.next());
 *         }
 *
 *         return leastNum;
 *     }
 */
