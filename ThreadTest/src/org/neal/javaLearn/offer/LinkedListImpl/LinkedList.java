package org.neal.javaLearn.offer.LinkedListImpl;

public class LinkedList<E> {


    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node() {
            this(null, null);
        }

        public Node(E e) {
            this(e, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    int size;

    public LinkedList(){
        dummyHead = new Node(null,null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void addFirst(E e){
        add(0,e);
//        Node node = new Node(e);
//        node.next = head;
//        head = node;

        //等价于上面三句话
//        head = new Node(e,head);
        size++;
    }

    public void add(int index,E e){
        if(index < 0 || index > size)
            throw new IllegalArgumentException();

        //使用虚拟头结点可统一添加节点的逻辑
        // 不用对第一个节点进行特殊处理
//        if(index == 0)
//            addFirst(e);
//        else{
            Node prev = dummyHead;
            for(int i=0; i<index; i++)
                prev = prev.next;
//
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;

//          等价于上面三行代码
            prev.next = new Node(e,prev.next);
            size++;
//        }

    }

    public void addLast(E e){
        add(size,e);
    }
}
