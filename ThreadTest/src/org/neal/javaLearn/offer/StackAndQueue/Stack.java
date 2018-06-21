package org.neal.javaLearn.offer.StackAndQueue;

public interface Stack<E> {

    int getSize();
    boolean isEmpty();
    E pop();
    E peek();
    void push(E e);

}
