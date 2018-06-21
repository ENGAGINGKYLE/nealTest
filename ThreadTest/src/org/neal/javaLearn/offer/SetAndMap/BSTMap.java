package org.neal.javaLearn.offer.SetAndMap;

public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private class Node{
        K key;
        V value;
        Node left;
        Node right;

        public Node(K key,V value){
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    @Override
    public void add(K key, V value) {
        add(root,key,value);
    }

    private Node add(Node node, K key, V value) {
        if(node == null){
            return new Node(key,value);
        }

        if(key.compareTo(node.key) < 0){
            add(node.left,key,value);
        }else if(key.compareTo(node.key) > 0){
            add(node.right,key,value);
        }else{
            node.value = value;
        }
        size++;
        return node;
    }

    private Node getNode(Node node,K key){
        if(node == null){
            return null;
        }

        if(key.compareTo(node.key) < 0){
            return getNode(node.left,key);
        }else if(key.compareTo(node.key) > 0){
            return getNode(node.right,key);
        }else{
            return node;
        }

    }

    private Node minimun(){
        return minimun(root);
    }

    private Node minimun(Node node) {
        if(node.left == null){
            return node;
        }
        return minimun(node.left);
    }

    public Node removeMin(){
        return removeMin(root);
    }

    private Node removeMin(Node node){
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }else{
            return removeMin(node.left);
        }
    }
    @Override
    public V remove(K key) {

        return remove(root,key).value;

    }

    private Node remove(Node node, K key) {
        if(getNode(node,key) == null){
            return null;
        }

        if(key.compareTo(node.key) < 0){
            return remove(node.left,key);
        }else if(key.compareTo(node.key) > 0){
            return remove(node.right,key);
        }else{
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            Node successor = minimun(node.right);
            successor.left = node.left;
            successor.right = removeMin(node.right);
            node.right = node.left = null;
            return successor;
        }

    }

    @Override
    public boolean contains(K key) {

        return getNode(root,key) != null;

    }

    @Override
    public V get(K key) {
        Node node = getNode(root,key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        if(getNode(root,key) != null){
            getNode(root,key).value = newValue;
        }
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
