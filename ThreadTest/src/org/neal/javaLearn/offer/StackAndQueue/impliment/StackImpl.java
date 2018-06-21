package org.neal.javaLearn.offer.StackAndQueue.impliment;

import org.neal.javaLearn.offer.StackAndQueue.ArrayImpl;
import org.neal.javaLearn.offer.StackAndQueue.Stack;

public class StackImpl<E> implements Stack<E> {

    private ArrayImpl<E> array;

    public StackImpl(int capacity){
        array = new ArrayImpl<>(capacity);
    }

    public StackImpl(){
//        this(10);
        array = new ArrayImpl<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: [");
        for(int i=0; i<array.getSize(); i++){
            res.append(array.get(i));
            if(i != array.getSize()-1)
                res.append(",");
        }
        res.append("] top");
        return res.toString();
    }


}
