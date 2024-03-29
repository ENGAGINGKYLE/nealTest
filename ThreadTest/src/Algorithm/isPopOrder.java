package Algorithm;

import org.junit.Test;

/**
 * 一个序列是栈的压入顺序  判断另一个序列是否为弹出顺序
 */
import java.util.Stack;

public class isPopOrder {
    //判断一个数组是否是另一个栈的出栈顺序

    @Test
    public void test(){
        int[] num = {1,2,3,4,5};
        int[] num1={1,2,3,5,4};
        int[] num2={2,1,5,3,4};
        int[] num3 = {2,1,5,4,3};
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        for(int i=4;i>=0;i--){
            s2.push(num3[i]);
        }

        System.out.println(testOrder(num,s1,s2));
    }

    public boolean testOrder(int[] num,Stack<Integer> s1,Stack<Integer> s2){
        int length = num.length;
        for(int i=0;i<length;i++){
            s1.push(num[i]);
            while(!s1.isEmpty() && s2.lastElement().intValue()==s1.lastElement().intValue()){
                s1.pop();
                s2.pop();
            }
        }
        if(!s1.isEmpty()){return false;
        }
        return true;
    }

}
