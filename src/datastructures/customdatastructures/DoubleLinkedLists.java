package datastructures.customdatastructures;

import utils.CustomNode;
import utils.Employee;

public class DoubleLinkedLists<E> {
    private CustomNode<E> head;
    private CustomNode<E> tail;
    private int size;

    public CustomNode<E> getTail() {
        return tail;
    }

    public void setTail(CustomNode<E> tail) {
        this.tail = tail;
    }

    public CustomNode<E> getHead() {
        return head;
    }

    public void setHead(CustomNode<E> head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty(){
        return head ==null;
    }

    public void printDoubleLinkedList(){
        CustomNode<E> current = head;
        System.out.println();
        System.out.print(" HEAD ");
        System.out.print(" null <-> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" <-> ");
            current = current.getNext();
        }
        System.out.print("null");
        System.out.println();
    }

    public void printDoubleLinkedListreverse(){
        CustomNode<E> current = tail;
        System.out.println();
        System.out.print(" tail ");
        System.out.print(" null <-> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(current);
            System.out.print(" <-> ");
            current = current.getPrevious();
        }
        System.out.print("null");
        System.out.println();
    }

    public CustomNode<E> addFromFront(E e){
        CustomNode<E> node = new CustomNode<>(e);
        if(head == null){
            head = node;
            tail  = node;
            node.setNext(null);
            node.setPrevious(null);
            size++;
            return node;
        }
        else{
            node.setNext(head);
            head.setPrevious(node);
            node.setPrevious(null);
            head = node;
            size++;
            return node;
        }


    }

    public CustomNode<E> addFromLast(E e){
        CustomNode<E> node = new CustomNode<>(e);
        if(head==null){
            head = node;
            node.setNext(null);
            node.setPrevious(null);
            size++;
            return node;
        }else{
            tail.setNext(node);
            node.setPrevious(tail);
            tail = node;
            size++;
            return node;
        }

        }
    public CustomNode<E> removeFromLast(){
        CustomNode<E> removedNode = tail;
        if (isEmpty()){
            return null;
    }
        else if(tail.getPrevious()==null){
            head =null;
            return tail;
        }else{
            CustomNode<E> current = tail.getPrevious();
            current.setNext(null);
            tail.setPrevious(null);
            tail=current;
            size--;
            return removedNode;
        }
    }

    public CustomNode<E> removeFromFirst(){
        if (isEmpty()){
            return null;
        }else{

            CustomNode<E> removedNode = head;
            CustomNode<E> current = head.getNext();
            current.setPrevious(null);
            head.setNext(null);
            head = current ;
            size--;
            return removedNode;
        }
    }

    public int addBefore(E e,E addingElement){
        if(head ==null){
            return -1;
        }
         if((head.getObj()).equals(e)){
            addFromFront(addingElement);
            return 0;
        }
        else {
            CustomNode<E> current = head;
            for (int i = 0; i < getSize() - 1; i++) {
                if ((current.getObj()).equals(e)) {
                    CustomNode<E> node = new CustomNode<>(addingElement);
                    CustomNode<E> prev = current.getPrevious();
                    prev.setNext(node);
                    node.setPrevious(prev);
                    node.setNext(current);
                    current.setPrevious(node);
                    size++;
                    return 0;
                }
                current = current.getNext();
            }

//
            return -1;
        }
    }


    public int remove(E e){

        if(head==null){
            return -1;
        }
        if((tail.getObj()).equals(e)){
            removeFromLast();
            return 0;
        }
        else if((head.getObj()).equals(e)){
            removeFromFirst();
            return 0;
        }
        else {
            CustomNode<E> current = head;
            for (int i = 0; i < getSize() - 1; i++) {

                if ((current.getObj()).equals(e)) {
                    CustomNode<E> prev = current.getPrevious();
                    CustomNode<E> next = current.getNext();

                    prev.setNext(next);
                    next.setPrevious(prev);
                    current.setPrevious(null);
                    current.setNext(null);
size--;
                    return 0;
                }else {
                    current = current.getNext();
                }
            }

//
            return -1;
        }

    }

    public static void main(String[]  args){

        DoubleLinkedLists<Employee> DlinkedList = new DoubleLinkedLists<>();
        Employee emp1 = new Employee(122,"Harvey Spector",63000);
        Employee emp2 = new Employee(123,"Mike Ross",80000);
        Employee emp3 = new Employee(124,"Jessica Pearson",75000);
        Employee emp4 = new Employee(125,"rachel Zane",50000);
        Employee emp5 = new Employee(126,"Lious Litt",50000);

        DlinkedList.addFromFront(emp3);
        DlinkedList.addFromFront(emp2);
        DlinkedList.addFromFront(emp1);
        DlinkedList.printDoubleLinkedList();
        System.out.println("head is " + DlinkedList.getHead() + " tail is " + DlinkedList.getTail() + "Size is "+ DlinkedList.getSize());

        DlinkedList.addFromLast(emp4);
        DlinkedList.printDoubleLinkedList();
        System.out.println("head is " + DlinkedList.getHead() + " tail is " + DlinkedList.getTail() + "Size is "+ DlinkedList.getSize());
        DlinkedList.printDoubleLinkedListreverse();

        DlinkedList.removeFromLast();
        DlinkedList.printDoubleLinkedList();
        System.out.println("head is " + DlinkedList.getHead() + " tail is " + DlinkedList.getTail() + "Size is "+ DlinkedList.getSize());

        DlinkedList.removeFromFirst();
        DlinkedList.printDoubleLinkedList();
        System.out.println("head is " + DlinkedList.getHead() + " tail is " + DlinkedList.getTail() + "Size is "+ DlinkedList.getSize());

        System.out.println(DlinkedList.remove(emp2));
        System.out.println("head is " + DlinkedList.getHead() + " tail is " + DlinkedList.getTail() + "Size is "+ DlinkedList.getSize());
        DlinkedList.addFromFront(emp3);
        DlinkedList.addFromFront(emp2);
        DlinkedList.addFromFront(emp1);
        DlinkedList.printDoubleLinkedList();
        System.out.println(DlinkedList.remove(emp5));

        DlinkedList.addBefore(emp2,emp5);
        DlinkedList.printDoubleLinkedList();
        System.out.println("head is " + DlinkedList.getHead() + " tail is " + DlinkedList.getTail() + "Size is "+ DlinkedList.getSize());
        DlinkedList.printDoubleLinkedListreverse();
    }
}
