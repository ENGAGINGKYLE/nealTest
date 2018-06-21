package org.neal.javaLearn.offer.jianzhiOffer;

//定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。

import java.util.Stack;

public class GetMinInStack {

    /**思路：用一个栈data保存数据，用另外一个辅助栈min保存依次入栈最小的数
     * 比如，data中依次入栈，5,  4,  3, 8, 10, 11, 12, 1
     * 则min依次入栈，5,  4,  3，3,3, 3, 3, 1
     * 每次入栈的时候，如果入栈的元素比min中的栈顶元素小或等于则入栈，否则不如栈。
     */
    Stack data = new Stack();
    Stack min = new Stack();

    public void push(int node) {
        if (min.empty()) {
            min.push(node);
        } else {
            int top = (int) min.peek();
            if (node < top) {
                min.push(node);
            } else {
                min.push(top);
            }
        }
        data.push(node);
    }

    public void pop() {
        if (!(data.empty())) {
            data.pop();
            min.pop();
        }
    }

    public int top() {
        return (int) data.peek();
    }

    public int min() {
        if (min.empty()) {
            return 0;
        }
        return (int) min.peek();
    }

}
