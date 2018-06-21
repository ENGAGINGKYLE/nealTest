package org.neal.javaLearn.offer.LinkedListImpl;

public class Solution {
    public Node remove(Node head,Integer val){
        if(head == null){
            return null;
        }
        head.next = remove(head.next,val);
        if(head.next.equals(val)){
            return head.next;
        }else{
            return head;
        }
        //相当于上述代码
        //return head.val == val ? head.next : head;

    }
}
