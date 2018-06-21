package org.neal.javaLearn.offer.myoffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，从尾到头打印链表每个节点的值。
 */
public class PrintFromTopToBottom {
    public class Node{
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    //使用栈实现
    public ArrayList<Integer> printList(Node node){
        if(node == null){
            ArrayList<Integer> arrayList = new ArrayList<>();
            return arrayList;
        }

        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        while(node != null){
            stack.push(node.val);
            node = node.next;
        }

        while(!stack.isEmpty()){
            arrayList.add(stack.pop());
        }
        return arrayList;
    }


    //递归实现
    public void printLinkedList(Node node){
        if(node != null){
            if(node.next != null){
                printLinkedList(node.next);
            }
            System.out.println(node.val);
        }
    }

}
