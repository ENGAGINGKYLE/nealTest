package org.neal.javaLearn.offer.jianzhiOffer;

//输入一个链表，反转链表后，输出链表的所有元素。

public class ReverseList {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;

        ListNode pPre = null;
        ListNode p = head;
        ListNode pNext = head.next;
        ListNode newHead = null;

        while (p != null) {
            pNext = p.next;//一定要记录下来后面的节点
            if (pNext == null)
                newHead = p;
            p.next = pPre;//这里的方向已经转变
            pPre = p;
            p = pNext;//将保存的后面的节点作为下一次循环的p

        }
        return newHead;

    }

}
