package org.neal.javaLearn.offer.BinarySearchTree;

public enum Order {
    preOrder(0,"前序遍历"),
    inOrder(1,"中序遍历"),
    postOrder(2,"后序遍历");

    int signal;
    String msg;

    Order(int signal, String msg) {
        this.signal = signal;
        this.msg = msg;
    }

    public int getSignal() {
        return signal;
    }

    public String getMsg() {
        return msg;
    }
}
