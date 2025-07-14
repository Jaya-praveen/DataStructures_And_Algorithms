package datastructures.pcollections;

import utils.Employee;

import java.util.HashMap;

public class pHashMap {
    public static void main(String[] args) {
        HashMap<String, Employee> map = new HashMap<>();

        Employee emp1 = new Employee(122,"Harvey Spector",63000);
        Employee emp2 = new Employee(123,"Mike Ross",80000);
        Employee emp3 = new Employee(124,"Jessica Pearson",75000);
        Employee emp4 = new Employee(125,"rachel Zane",50000);
        Employee emp5 = new Employee(126,"Lious Litt",50000);

        map.put("Harvey",emp1);
        map.put("Mike",emp2);
        map.put("Jessica",emp3);
        map.put("Rachel",emp3);

        //wont override emp2
        map.putIfAbsent("Mike",emp4);
        System.out.println("\nAll employees:");
        map.forEach((key, emp) -> System.out.println(key + " => " + emp));
        map.putIfAbsent("Jessica",emp4);
        System.out.println("Get emp4: "+map.get("Jessica"));

        System.out.println("check key :Jessica"+map.containsKey("Mike"));
        System.out.println("Check value : emp1"+map.containsValue(new Employee(122,"Harvey Spector",63000)));

        map.remove("Jessica");

        map.replace("Rachel",new Employee(121,"Katrina Bennet",55000));
        map.computeIfAbsent("Lious",e -> emp5);
        map.computeIfPresent("Lious",(k,v)->{
            v.setSalary(v.getSalary()+5000);
        return v;
        });

        map.merge("Harvey",new Employee(122,"Harvey Spector",700000),(oldEmp,newEmp)->{
            oldEmp.setSalary(oldEmp.getSalary() + newEmp.getSalary());
            return oldEmp;
        });

        map.replaceAll((k,v)->{
            v.setSalary(v.getSalary()*1.1);
            return v;
        });

        System.out.println("\nFinal Employees List:");
        map.forEach((k,v) -> System.out.println((k+ " -> "+v)));

        System.out.println("\nKeys: " + map.keySet());
        System.out.println("\nValues" + map.values());
        System.out.println("\nEntries" + map.entrySet());

        double totalsalaries = map.values().stream().mapToDouble(Employee::getSalary).sum();
        System.out.println("Total salaries :" + totalsalaries);

        map.clear();
        System.out.println("\nIs map entry after clear" + map.isEmpty());


    }
}
