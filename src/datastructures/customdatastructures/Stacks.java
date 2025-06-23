package datastructures.customdatastructures;

import utils.Employee;

import java.util.EmptyStackException;

public class Stacks {
    private Employee[] stacks;
    private int top;

    public Stacks(int capacity){
        stacks = new Employee[capacity];
    }

    public void push(Employee e){
        if (top == stacks.length){
            Employee[]  newArray =  new Employee[2* stacks.length];
            System.arraycopy(stacks,0,newArray,0,stacks.length);
            stacks = newArray;
        }
        stacks[top++] = e;
    }

    public Employee pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        Employee removedEmployee = stacks[--top];
        stacks[top]=null;
        return removedEmployee;
    }

    public boolean isEmpty(){
        return top ==0;
    }

    public Employee peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return stacks[top-1];
    }

    public int size(){
        return top;
    }

    public void printStack(){
        for (Employee e:stacks){
         System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Stacks stk = new Stacks(4);

        Employee emp1 = new Employee(122,"Harvey Spector",63000);
        Employee emp2 = new Employee(123,"Mike Ross",80000);
        Employee emp3 = new Employee(124,"Jessica Pearson",75000);
        Employee emp4 = new Employee(125,"rachel Zane",50000);
        Employee emp5 = new Employee(126,"Lious Litt",50000);

        stk.push(emp3);
        stk.push(emp2);
        stk.push(emp1);
        stk.push(emp4);
        System.out.println("The stack elements are :");
        stk.printStack();
        System.out.println("size of stack is :" + stk.stacks.length);

        System.out.println("The stack elements are :");
        stk.push(emp5);
        stk.printStack();
        System.out.println("size of stack is :" + stk.stacks.length);

        stk.pop();
        System.out.println("The stack elements are :");
        stk.printStack();

    }


}
