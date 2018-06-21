package Algorithm;

import org.junit.Test;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出
 * 每一个数字。例如：
 * 1  2  3  4  5
 * 6  7  8  9  10
 * 11 12 13 14 15
 * 16 17 18 19 20
 * 21 22 23 24 25
 *
 * 打印：1 2 3 4 5 10 15 20 25 24 23 22 21 16 11 6 7 8 9 14 19 18 17 12 13
 */

public class ClockwiseOutput {
    //顺时针打印一个矩阵

    @Test
    public void test(){
        int[][] num = new int[100][100];
        int n = 6;
        int count =1;

        for(int i=0;i<n;i++){
            for(int j =0;j<n;j++){
                num[i][j]=count++;
            }
        }
        output(num,0,n-1);
    }

    /**
     * 每次输出一个外层
     * @param num
     * @param start  开始列
     * @param end  结束列
     */
    public void output(int[][] num,int start,int end){
        if(start>end || end<=0)return;
        for(int i=start;i<=end;i++){
            System.out.print(num[start][i]+" ");
        }
        for(int i=start+1;i<=end;i++){
            System.out.print(num[i][end]+" ");
        }

        for(int i=end-1;i>=start;i--){
            System.out.print(num[end][i]+" ");
        }
        for(int i=end-1;i>start;i--){
            System.out.print(num[i][start]+" ");
        }

        output(num,start+1,end-1);
    }
}
