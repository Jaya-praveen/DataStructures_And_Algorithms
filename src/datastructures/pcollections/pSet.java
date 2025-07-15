package datastructures.pcollections;

import java.util.*;
import java.util.HashSet;

import utils.Employee;

public class pSet {
    public static void main(String[] args) {
        Set<Employee> set = new HashSet<>();

        Employee emp1 = new Employee(122,"Harvey Spector",63000);
        Employee emp2 = new Employee(123,"Mike Ross",80000);
        Employee emp3 = new Employee(124,"Jessica Pearson",75000);
        Employee emp4 = new Employee(125,"rachel Zane",50000);
        Employee emp5 = new Employee(126,"Lious Litt",50000);

        set.add(emp1);
        set.add(emp2);
        set.add(emp3);
        set.add(emp5);
        set.add(new Employee(125,"rachel Zane",50000));

        System.out.println("check contaims Harvey"+set.contains(new Employee(122,"Harvey Spector",63000)));

        System.out.println("Size: "+ set.size());

        System.out.println("check empty "+set.isEmpty());

//        System.out.println("\n iterating using iterator()");
//        Iterator<Employee> itr =new set.iterator();
//        while(itr.hasNext()){
//            System.out.println(itr.next());
//        }

        set.remove(emp2);
        System.out.println("\n r3emoved bob");
        set.forEach(System.out::println);

        System.out.println("\n using removeIf(id ==)");
        set.removeIf(e->e.getID() ==125);
        set.forEach(System.out::println);



    }
}
