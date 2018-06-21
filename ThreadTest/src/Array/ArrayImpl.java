package Array;


public class ArrayImpl<E> {
    private int size;
    private E[] data;

    public ArrayImpl(int container) {
        data = (E[]) new Object[container];
        size = 0;
    }

    public ArrayImpl(){
        this(10);
    }

    public int getSize(){
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCapacity(){
        return data.length;
    }

    public void add(int index, E e){

        if( index < 0 || index > size){
            throw new IllegalArgumentException();
        }

        if(data.length == size)
            resize(2 * data.length);


        for(int i = size-1; i >= index; i--){
            data[i+1] = data[i];
        }
        size++;
        data[index] = e;
    }

    public void addLast(E e){
        add(size,e);
    }

    public void addFirst(E e){
        add(0,e);
    }

    public int contain(E e){
        for(int i=0; i<size; i++){
            if(data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty(){
        if(size == 0)
            return true;
        return false;
    }

    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException();
        }

        E ret = data[index];

        for(int i=index+1; i<size; i++){
            data[i-1] = data[i];
        }
        size--;
        if(size == data.length/2)
            resize(data.length/2);
        return ret;
    }

    public void removeElement(E e){
        for(int i=0; i<size; i++){
            if(data[i].equals(e)){
                remove(i);
            }
        }
    }

    public void removeFirst(){
        remove(0);
    }

    public void removeLast(){
        remove(size-1);
    }

    public int find(E e){
        for(int i=0; i<size; i++){
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    public void set(int index, E e){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException();
        data[index] = e;
    }

    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for(int i=0; i<size; i++){
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for(int i = 0 ; i < size ; i ++){
            res.append(data[i]);
            if(i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
}
