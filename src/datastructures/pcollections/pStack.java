package datastructures.pcollections;

import utils.Employee;

import java.util.Stack;
import java.util.stream.Collectors;

public class pStack {
    public static void main(String[] args) {
        Employee emp1 = new Employee(122,"Harvey Spector",63000);
        Employee emp2 = new Employee(123,"Mike Ross",80000);
        Employee emp3 = new Employee(124,"Jessica Pearson",75000);
        Employee emp4 = new Employee(125,"rachel Zane",50000);
        Employee emp5 = new Employee(126,"Lious Litt",50000);

        Stack<Employee> stk =new Stack<>();
        System.out.println("\nadding elements to stack");
        stk.push(emp1);
        stk.push(emp2);
        stk.push(emp3);
        stk.push(emp4);
        System.out.println("\n elements in stack " + stk);
        System.out.println("\n top element is " +stk.peek());

        System.out.println(stk.pop());
        System.out.println("\n elements in stack " + stk);

        System.out.println("\nsearched "+ emp1 +"found at "+stk.search(emp1));

        String earners = stk.stream()
                .filter(e -> e.getSalary() >= 60000)
                .map(Employee::getName)
                .collect(Collectors.joining(", "));
        System.out.println("High earners gte 60k: " + earners + "\n");

        System.out.println("\nPopping all items …");
        while (!stk.empty()) {
            System.out.println("\npoping " + stk.pop());
        }
        System.out.println("\nIs  stack empty? " + stk.empty());


    }
}
