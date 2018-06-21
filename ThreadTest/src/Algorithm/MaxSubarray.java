package Algorithm;

import org.junit.Test;

/**
 * 输入一个整形数组，数组里有正数也有负数，数组中一个或连续的多个整数组成一个子数组。求所有子数组的和的最大值
 * O(n)
 */
public class MaxSubarray {
    //子数组最大和
    @Test
    public void test(){
        int[] num = {1,-2,3,10,-4,7,2,-5};
        //int[] num = {1,-2,3,10,-4,10,2,-5};
        System.out.println(maxSum(num));
    }

    public int maxSum(int[] num){
        int curSum = 0;
        int curMaxSum = -99999999;
        int start = 0;
        int end = 0;

        for(int i=0;i<num.length;i++){
            if(curSum<=0){
                curSum = num[i];
                start = i;
            }
            else{
                curSum += num[i];
            }
            if(curSum>curMaxSum){
                curMaxSum = curSum;
                end = i;
            }
        }
        for(int i = start;i<=end;i++){
            System.out.println(num[i]);
        }
        return curMaxSum;
    }

}
