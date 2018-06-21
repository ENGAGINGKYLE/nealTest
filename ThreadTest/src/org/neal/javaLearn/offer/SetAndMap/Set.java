package SetAndMap;

/**
 * 基于二分搜索树的集合实现
 * @param <E>
 */
public interface Set<E> {
    void add(E e);
    void remove(E e);
    boolean contaions(E e);
    int getSize();
    boolean isEmpty();

}
