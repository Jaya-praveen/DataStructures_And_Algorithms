package datastructures.customdatastructures;

public class Heaps {
    private int[] heap;
    private int size;

    public Heaps(int capacity){
        heap = new int[capacity];
    }

    public void insert(int value){
        if(isFull()){
            throw new IndexOutOfBoundsException("Heap is full");
        }
        heap[size] = value;
        fixHeapAbove(size);
        size++;

        System.out.println("inserted "+value);
    }

    public int delete(int index){
        if (isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        int parent = getParent(index);
        int deletedValue = heap[index];

        heap[index] = heap[size - 1];

        if(index ==0 || heap[index] < heap[parent]){
            fixHeapBelow(index,size-1);
        }
        else{
            fixHeapAbove(index);
        }
        size --;
        return deletedValue;
    }

    private void fixHeapBelow(int index,int lastHeapIndex){
        int childToSwap;

        while( index <= lastHeapIndex) {
            int leftChild = getChild(index, true);
            int rightChild = getChild(index, false);

            if (leftChild <= lastHeapIndex) {
                if (rightChild > lastHeapIndex) {
                    childToSwap = leftChild;
                } else {
                    childToSwap = (heap[leftChild] > heap[rightChild] ? leftChild : rightChild);
                }
                if (heap[index] < heap[childToSwap]) {
                    int tmp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap] = tmp;

                } else {
                    break;
                }

                index = childToSwap;
            } else {
                break;
            }
        }

    }

    private void fixHeapAbove(int index){
        int newValue = heap[index];
        while(index > 0 && newValue > heap[getParent(index)]){
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }
        heap[index] = newValue;
    }

    public boolean isFull(){
        return size == heap.length;
    }

    public int getParent(int index){
        return (index-1)/2;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int getChild(int index,boolean left){
        return 2*index+(left ? 1: 2);
    }

    public void printHeap(){
        for(int i=0;i<size;i++){
            System.out.print(heap[i]);
            System.out.print(", ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        Heaps heap =new Heaps(10);

        heap.insert(80);
        heap.insert(75);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);


        heap.printHeap();
        System.out.println(heap.delete(0));
        heap.printHeap();
        System.out.println(heap.delete(0));
        heap.printHeap();
        System.out.println(heap.delete(2));
        heap.printHeap();

    }
}
