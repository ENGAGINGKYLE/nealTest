package org.neal.javaLearn.offer.jianzhiOffer;

import java.util.HashMap;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）。
 */
public class CloneLinkedList {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }


    //方法一：用hashMap映射原链表，牺牲O（N）空间换来时间
    public RandomListNode Clone1(RandomListNode pHead)

    {

        if(pHead == null) return null;

        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();

        RandomListNode newHead = new RandomListNode(pHead.label);//复制链表的头结点

        RandomListNode pre = pHead, newPre = newHead;
        map.put(pre, newPre);

        //第一步，hashMap保存，原链表节点映射复制链表节点
        while(pre.next != null){
            newPre.next = new RandomListNode(pre.next.label);
            pre = pre.next;
            newPre = newPre.next;
            map.put(pre, newPre);
        }

        //第二步：找到对应的random
        pre = pHead;
        newPre = newHead;

        while(newPre != null){
            newPre.random = map.get(pre.random);
            pre = pre.next;
            newPre = newPre.next;
        }

        return newHead;
    }

    //方法二：不借用辅助空间
    public RandomListNode Clone2(RandomListNode pHead){
        if(pHead==null)
            return null;
        RandomListNode pCur = pHead;
        //第一步：复制next 如原来是A->B->C 变成A->A'->B->B'->C->C'
        while(pCur!=null){
            RandomListNode node = new RandomListNode(pCur.label);
            node.next = pCur.next;
            pCur.next = node;
            pCur = node.next;
        }

        //第二步
        pCur = pHead;
        //复制random pCur是原来链表的结点 pCur.next是复制pCur的结点
        while(pCur!=null){
            if(pCur.random!=null)
                pCur.next.random = pCur.random.next;
            pCur = pCur.next.next;
        }

        //第三步
        RandomListNode head = pHead.next;//复制链表的头结点
        RandomListNode cur = head;//偶数位置为复制链表
        pCur = pHead;//奇数位置为原链表
        //拆分链表
        while(pCur!=null){
            pCur.next = pCur.next.next;
            if(cur.next!=null)//注意最后一个复制节点的时候就没有next的next
                cur.next = cur.next.next;
            cur = cur.next;
            pCur = pCur.next;
        }
        return head;
    }
}
