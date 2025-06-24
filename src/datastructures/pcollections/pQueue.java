package datastructures.pcollections;

import utils.Employee;

import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.stream.Collectors;

public class pQueue {


    public static void main(String[] args) {


        Employee emp1 = new Employee(122, "Harvey Spector", 63000);
        Employee emp2 = new Employee(123, "Mike Ross", 80000);
        Employee emp3 = new Employee(124, "Jessica Pearson", 75000);
        Employee emp4 = new Employee(125, "rachel Zane", 50000);
        Employee emp5 = new Employee(126, "Lious Litt", 50000);

        Queue<Employee> que = new ArrayDeque<>();

        System.out.println("adding elements to queue");
        que.add(emp1);
        que.add(emp2);
        que.add(emp3);
        que.add(emp4);
        System.out.println("\n elements in stack " + que);
        System.out.println("\n  element is " + que.peek());//returns flse
        System.out.println("\n  element is " + que.element());//throws Exception

        String highEarners =
                que.stream()
                        .filter(e -> e.getSalary() >= 60_000)
                        .map(Employee::getName)
                        .collect(Collectors.joining(", "));
        System.out.println("\nHigh-salary employees : " + highEarners);

        System.out.println("\n  element is " + que.poll());//returns flse
        System.out.println("\n  element is " + que.remove());//throws Exception
        System.out.println("\n elements in stack " + que);

        que.clear();
        System.out.println("\n empty elements in stack ");

        try {
            que.element();               // will throw
        } catch (NoSuchElementException ex) {
            System.out.println("element() threw  : " + ex);
        }

        System.out.println("peek() returns     : " + que.peek());  // null
        try {
            que.remove();                // will throw
        } catch (NoSuchElementException ex) {
            System.out.println("remove() threw   : " + ex);
        }
        System.out.println("poll() returns     : " + que.poll());

    }
}
