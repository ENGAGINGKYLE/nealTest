package org.neal.javaLearn.offer.SetAndMap;

public class LinkedListMap<K, V> implements Map<K, V> {

    private class Node{
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(){
            this(null,null,null);
        }

        public Node(K key){
            this(key,null,null);
        }

        @Override
        public String toString(){
            return key.toString() + " : " + value.toString();
        }

    }

    private Node dummyHead;
    private int size;

    public LinkedListMap(){
        dummyHead = new Node();
        size = 0;
    }

    private Node getNode(K key){
        if(size == 0)
            return null;

        Node current = dummyHead.next;
        while(current != null){
            if(key.equals(current.key)){
                return current;
            }

            current = current.next;
        }
        return null;
    }

    @Override
    public void add(K key, V value) {
        if(getNode(key) == null){
            dummyHead.next = new Node(key,value,dummyHead.next);
            size++;
        }else{
            getNode(key).value = value;
        }
    }

    @Override
    public V remove(K key) {
        Node node = getNode(key);
        if(node == null){
            return null;
        }

        Node prev = dummyHead;
        while(prev.next != null){
            if(prev.next.key.equals(key)){
                break;
            }
            prev = prev.next;
        }

        if(prev.next != null){
            prev.next = node.next;
            node.next = null;
            return node.value;
        }

        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        return getNode(key).value;
    }

    @Override
    public void set(K key, V newValue) {
        if(getNode(key) != null)
            return;
        else
            getNode(key).value = newValue;

    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }
}
