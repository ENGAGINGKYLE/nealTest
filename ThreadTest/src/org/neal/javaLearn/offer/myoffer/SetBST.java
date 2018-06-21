package org.neal.javaLearn.offer.myoffer;


/**
 * 集合  去重
 * @param <E>
 */
public class SetBST<E extends Comparable<E>> implements Set<E>{
    private BST<E> bst;

    public SetBST(){
        bst = new BST<>();
    }


    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
