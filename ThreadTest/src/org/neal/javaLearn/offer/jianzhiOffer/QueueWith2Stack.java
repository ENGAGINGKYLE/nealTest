package org.neal.javaLearn.offer.jianzhiOffer;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */

public class QueueWith2Stack {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }


    public int pop() {

        while(!stack2.isEmpty())
        {
            return stack2.pop();
        }

        while(!stack1.isEmpty())
        {
            stack2.push(stack1.pop());
        }

        return stack2.pop();
    }

}
