package datastructures.customdatastructures;

public class ArrayLists<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] elements;
    private int  size;

    public ArrayLists(){
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void add(E e){
        ensureCapacity();
        elements[size++] = e;
    }

    public void ensureCapacity(){
            if (size == elements.length) {
                Object[] newElements = new Object[elements.length * 2];
                System.arraycopy(elements, 0, newElements, 0, elements.length);
                elements = newElements;
            }
    }

    public E get(int index){
        checkIndex(index);
        return (E) elements[index];
    }

    public void checkIndex(int index){
        if(index<0 || index >= size){
            throw new ArrayIndexOutOfBoundsException("given index :" + index +" is out of Array");
        }
    }

    public E remove(int index) {
        checkIndex(index);
        E removedElement = (E) elements[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null; // Clear the last element
        return removedElement;
    }


    public void clear(){
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }
    public int size() {
        return size;
    }

    public static void main(String[] args){
        ArrayLists<String> arr = new ArrayLists<>();
        arr.add("Java");
        arr.add("Python");
        arr.add("C++");
        arr.add("Go");
        for(int i=0;i<arr.size();i++){
            System.out.print(" - " + arr.get(i) );
        }
        System.out.println();
        arr.remove(2);
        for(int i=0;i<arr.size();i++){
            System.out.print(" - " + arr.get(i) );
        }
    }

}
