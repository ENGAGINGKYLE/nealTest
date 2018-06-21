package org.neal.javaLearn.offer.StackAndQueue.impliment;

import org.neal.javaLearn.offer.StackAndQueue.ArrayImpl;
import org.neal.javaLearn.offer.StackAndQueue.Queue;

/**
 * 普通队列
 * @param <E>
 */
public class QueueImpl<E> implements Queue<E> {

    ArrayImpl<E> array;

    public QueueImpl(int capacity){
        array = new ArrayImpl<>(capacity);
    }

    public QueueImpl(){
        array = new ArrayImpl<>();
    }

    @Override
    public void enqueue(E e) {
       array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

}
