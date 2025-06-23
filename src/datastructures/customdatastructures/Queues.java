package datastructures.customdatastructures;

import utils.Employee;

import java.util.NoSuchElementException;

public class Queues {

    private Employee[] q;
    private int front;
    private int back;

    public Queues(int capacity) {
        q = new Employee[capacity];
    }

    public int size() {
        if (front < back) {
            return back - front;
        } else {
            return back - front + q.length;
        }
    }

    public void add(Employee e) {
        if (size() == q.length - 1) {
            int numItems = size();
            Employee[] newArray = new Employee[2 * q.length];
            System.arraycopy(q, front, newArray, 0, q.length - front);
            System.arraycopy(q, 0, newArray, q.length - front, back);
            q = newArray;

            front = 0;
            back = numItems;

        }

        q[back] = e;
        if (back < q.length - 1) {
            back++;
        } else {
            back = 0;
        }
    }

    public Employee remove() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        Employee e = q[front];
        q[front] = null;
        front++;
        if (size() == 0) {
            front = 0;
            back = 0;
        } else if (front == q.length) {
            front = 0;
        }
        return e;
    }


    public Employee peek() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        return q[front];
    }

    public void printQueue() {
        if (front <= back) {
            for (int i = front; i < back; i++) {
                System.out.println(q[i]);
            }
        } else {
            for (int i = front; i < q.length; i++) {
                System.out.println(q[i]);
            }
            for (int i = 0; i < q.length; i++) {
                System.out.println(q[i]);
            }
        }
    }


    public static void main(String[] args) {
        Queues que = new Queues(5);

        Employee emp1 = new Employee(122, "Harvey Spector", 63000);
        Employee emp2 = new Employee(123, "Mike Ross", 80000);
        Employee emp3 = new Employee(124, "Jessica Pearson", 75000);
        Employee emp4 = new Employee(125, "rachel Zane", 50000);
        Employee emp5 = new Employee(126, "Lious Litt", 60000);
        Employee emp6 = new Employee(127,"Donna Paulsen",50000);

        que.add(emp3);
        que.add(emp2);
        que.remove();
        que.add(emp1);
        que.remove();
        que.add(emp4);
        que.remove();
        que.add(emp5);
        que.remove();
        System.out.println("The stack elements are :");
        que.printQueue();
        System.out.println();

        que.add(emp3);
        que.add(emp2);
        que.add(emp1);
        que.add(emp4);
        que.add(emp5);

        System.out.println("The stack elements are :");
        que.printQueue();
        System.out.println();

        System.out.println("The stack elements are :");
        que.add(emp5);
        que.printQueue();

        que.remove();
        System.out.println("The stack elements are :");
        que.printQueue();
    }
}


