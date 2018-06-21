package org.neal.javaLearn.offer.jianzhiOffer;

//输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。

public class MergeList {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    //递归方法
    public ListNode Merge1(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        else if (list2 == null)
            return list1;
        ListNode mergeHead = null;
        if (list1.val < list2.val) {
            mergeHead = list1;
            mergeHead.next = Merge1(list1.next, list2);
        } else {
            mergeHead = list2;
            mergeHead.next = Merge1(list1, list2.next);
        }
        return mergeHead;

    }

    //非递归方法
    public ListNode Merge2(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null)
            return null;
        if (list1 == null && list2 != null)
            return list2;
        if (list1 != null && list2 == null)
            return list1;
        ListNode head = null;
        if (list1.val < list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }
        ListNode cur = head;
        cur.next = null;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
            cur.next = null;
        }
        if (list1 == null && list2 != null) {
            cur.next = list2;
        } else if (list2 == null && list1 != null) {
            cur.next = list1;
        }
        return head;
    }

}
