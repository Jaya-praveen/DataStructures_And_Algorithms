package datastructures.customdatastructures;


import utils.CustomNode;
import utils.Employee;

public class LinkedLists<E> {

    private CustomNode<E> head;
    private int size;



    public int getSize() {
        return size;
    }


    public CustomNode<E> getHead() {
        return head;
    }

    public void setHead(CustomNode<E> head) {
        this.head = head;
    }


    public void addToFront(E e) {
        CustomNode<E> node = new CustomNode<>(e);
        node.setNext(head);
        head = node;
        size++;
    }

    public CustomNode<E> removeFromFront() {
        if (isEmpty()) {
            return null;
        } else {
            CustomNode<E> removedNode = head;
            head = head.getNext();
            size--;
            removedNode.setNext(null);
            System.out.println("Removed "+removedNode);
            return removedNode;
        }
    }

    public CustomNode<E> addToLast(E e){
        CustomNode<E> node = new CustomNode<>(e);
        if(head==null){
            head = node;
            size++;
            return node;
        }
        else {
            CustomNode<E> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(node);
            size++;
            return node;
        }
    }

    public CustomNode<E> rempoveFromLast(){
        if(isEmpty()){
            System.out.println("inside rempoveFromLast : list is empty :( ");
            return null;
        }
        else {
            CustomNode<E> current = head;
            CustomNode<E> penultimate=null;
            while (current.getNext() != null) {
                penultimate = current;
                current = current.getNext();
            }
            penultimate.setNext(null);
            size--;
            return penultimate;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        CustomNode<E> current = head;
        System.out.println();
        System.out.print(" HEAD -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.print("null");
        System.out.println();
    }

    public static void main(String[] args){
        LinkedLists<Employee> linkedlist = new LinkedLists<>();

        Employee emp1 = new Employee(122,"Harvey Spector",63000);
        Employee emp2 = new Employee(123,"Mike Ross",80000);
        Employee emp3 = new Employee(124,"Jessica Pearson",75000);
        Employee emp4 = new Employee(125,"rachel Zane",50000);
        linkedlist.addToFront(emp3);
        linkedlist.addToFront(emp2);

        linkedlist.addToFront(emp1);
        linkedlist.printList();

        //check if its empty
        System.out.println(linkedlist.isEmpty());
        //check size
        System.out.println(linkedlist.getSize());

         //removing a node from front
        linkedlist.removeFromFront();
        linkedlist.printList();

        linkedlist.addToLast(emp4);
        linkedlist.printList();

        linkedlist.rempoveFromLast();
        linkedlist.printList();


    }
}
