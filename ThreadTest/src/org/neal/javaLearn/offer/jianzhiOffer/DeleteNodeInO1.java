package org.neal.javaLearn.offer.jianzhiOffer;

//给定单向链表头指针和一个节点指针，在O(1)时间删除链表结点


public class DeleteNodeInO1 {


    /*
    对于删除节点，我们普通的思路就是让该结点的前一个节点指向改节点的下一个节点
    */
    public void delete(Node head, Node toDelete){
        if(toDelete == null){
            return ;
        }
        if(toDelete.next != null){//删除的节点不是尾节点
            toDelete.val = toDelete.next.val;
            toDelete.next = toDelete.next.next;
        }else if(head == toDelete){//链表只有一个节点，删除头结点也是尾节点
            head = null;
        }else{ //删除的节点是尾节点的情况
            Node node = head;
            while(node.next != toDelete){//找到倒数第二个节点
                node = node.next;
            }
            node.next = null;
        }
    }
}

class Node{
    public int val;
    public Node next;
}