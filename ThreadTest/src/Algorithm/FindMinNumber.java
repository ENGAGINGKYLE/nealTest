package Algorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * 输入一个正整数数组，把数组里所有数字凭借起来排成一个数，打印能拼接出的所有数字中最小的一个数
 * {3,32,321}  321323
 */
public class FindMinNumber {
    //数组组成的最小数

    @Test
    public void test(){
        int[] num={1,5,9,13,442,44,6,21,211};
        qsort(num,0,num.length-1);
        System.out.println(Arrays.toString(num));
    }

    public void qsort(int[] num,int left,int right){
        if(left<right){
            int partition = partition(num,left,right);
            qsort(num,left,partition-1);
            qsort(num,partition+1,right);
        }
    }

    public int partition(int[] num,int left,int right){
        int partition = num[left];
        while(left<right){
            while((num[right]==partition || isMBigerThanN(num,num[right],partition)) && left<right){
                right--;
            }
            swap(num,left,right);
            while((num[left]==partition || isMBigerThanN(num,partition,num[left])) && left<right){
                left++;
            }
            swap(num,left,right);
        }

        return left;
    }

    public void swap(int[] num,int m,int n){
        int temp = num[m];
        num[m]=num[n];
        num[n]=temp;
    }

    public boolean isMBigerThanN(int[] num,int m,int n){
        String num1 = String.valueOf(m);
        String num2 = String.valueOf(n);

        int temp1 = Integer.parseInt(num1+num2);
        int temp2 = Integer.parseInt(num2+num1);

        if(temp1>temp2){
            return true;
        }
        else{
            return false;
        }
    }
}
