package org.neal.javaLearn.offer.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//二叉搜索树中的元素必须是可比较的
public class BSTImpl<E extends Comparable<E>> {

    private class Node{
        public E e;
        public Node left,right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BSTImpl(){
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    // 向二分搜索树中添加新的元素e
    public void add(E e){
        if(root == null)
            root = new Node(e);
        else
            add(root,e);
//        更简便的插入方式
//        root = addSimple(root,e);
    }

    //向以node为根的二分搜索树中插入元素e 递归算法
    // 返回插入新节点后二分搜索树的根
    private void add(Node node, E e){
        //终止条件
        if(e.equals(node.e)){
            return;
        } else if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        }else if(e.compareTo(node.e) > 0 && node.right == null){
            node.right = new Node(e);
            size++;
            return;
        }

        //递归实现
        if(e.compareTo(node.e) < 0){
            add(node.left,e);
        }else{
            add(node.right,e);
        }
    }

    private Node addSimple(Node node,E e){
        if(node == null){
            size++;
            return new Node(e);
        }

        if(e.compareTo(node.e) < 0)
            node.left = addSimple(node.left,e);
        else if(e.compareTo(node.e) > 0)
            node.right = addSimple(node.right,e);

        return node;
    }

    public boolean contains(E e){
        return contains(root,e);
    }

    //看以node为根的二分搜索树中是否含有元素e，递归算法
    private boolean contains(Node node, E e) {
        if(node == null)
            return false;

        if(e.compareTo(node.e) == 0)
            return true;
        else if(e.compareTo(node.e) < 0)
            return contains(node.left,e);
        else
            return contains(node.right,e);
    }

    //二叉树遍历，前序遍历
    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node node){
//
//        if(node == null)
//            return;
//

        if(node != null){
            System.out.print(node.e+" ");
            preOrder(node.left);
            preOrder(node.right);
        }

    }

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node) {
        if(node == null)
            return;

        inOrder(node.left);
        System.out.print(node.e + " ");
        inOrder(node.right);
    }

    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node) {
        if(node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.e + " ");
    }


    //二分搜索树的遍历
    public void order(int signal){
        order(root,signal);
    }

    private void order(Node node,int signal) {
        if(node == null){
            return;
        }
        if(signal == Order.preOrder.signal)
            System.out.print(node.e + " ");
        order(node.left,signal);
        if(signal == Order.inOrder.signal)
            System.out.print(node.e + " ");
        order(node.right,signal);
        if(signal == Order.postOrder.signal)
            System.out.print(node.e + " ");

    }

    //非递归的前序遍历  栈实现
    public void preOrderNR(){

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.print(cur.e + " ");

            if(cur.right != null)
                stack.push(cur.right);
            if(cur.left != null)
                stack.push(cur.left);
        }
    }

    //层序遍历  队列实现
    public void levelOrder(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node cur = queue.remove();
            System.out.print(cur.e + " ");

            if(cur.left != null)
                queue.add(cur.left);
            if(cur.right != null)
                queue.add(cur.right);
        }
    }

    //寻找最小元素
    public E minimum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty!");

        return minimum(root).e;
    }

    //寻找最大元素
    public E maxmum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty!");

        return maxmum(root).e;
    }

    //寻找最小节点
    public Node minimum(Node node){
        if(node.left == null){
            return node;
        }
        return minimum(node.left);

    }

    //寻找最大节点
    public Node maxmum(Node node){
        if(node.right == null){
            return node;
        }
        return maxmum(node.right);
    }

    //删除最小值
    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    /**
     * 删除已node为根节点的二分搜索树的最小节点
     * @param node
     * @return 删除节点后的新二分搜索树的根
     */
    private Node removeMin(Node node) {
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    //删除最大值
    public E removeMax(){
        E ret = maxmum();
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node node){
        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    //删除任意值
    public void remove(E e){
       root = remove(root,e);
    }

    /**
     * 删除以node为根的二分搜索树中值为e的节点，递归
     * @param node
     * @param e
     * @return 删除节点后新的二叉搜索树的根
     */
    private Node remove(Node node, E e) {
        if(node == null)
            return null;

        if(e.compareTo(node.e) < 0){
            node.left = remove(node.left,e);
            return node;
        }else if(e.compareTo(node.e) > 0){
            node.right = remove(node.right, e);
            return node;
        }else{//e.compareTo(node.e) == 0

            if(node.left == null){// 只有右孩子节点
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            if(node.right == null){//只有左孩子节点
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            //待删除节点左右子树均不为空的情况
            //找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
            //用这个节点顶替待删除节点的位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;
            //找到比待删除节点小的最大节点，即待删除节点左子树的最大节点
            //用这个节点同样可以代替待删除节点的位置
//            Node successor = maxmum(node.left);
//            successor.left = removeMax(node.left);
//            successor.right = node.right;
//            node.left = node.right = null;
//            return successor;
            return successor;



        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generaterBSTString(root,0,res);
        return res.toString();
    }

    private void generaterBSTString(Node node, int depth, StringBuilder res) {
        if(node == null){
            res.append(generaterDepthString(depth) + "null\n");
            return;
        }

        res.append(generaterDepthString(depth) + node.e + "\n");
        generaterBSTString(node.left,depth + 1, res);
        generaterBSTString(node.right,depth + 1, res);

    }

    private String generaterDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for(int i=0; i<depth; i++){
            res.append("--");
        }
        return res.toString();
    }


}
