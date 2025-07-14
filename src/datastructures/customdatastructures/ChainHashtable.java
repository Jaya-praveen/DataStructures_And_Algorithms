package datastructures.customdatastructures;

import utils.Employee;
import utils.StoredEmployee;

import java.util.LinkedList;
import java.util.ListIterator;

public class ChainHashtable {
    private LinkedList<StoredEmployee>[]  hashtable;

    public ChainHashtable() {
        hashtable = new LinkedList[10];
        for(int i=0;i<hashtable.length;i++){
            hashtable[i] = new LinkedList<StoredEmployee>();
        }
    }

    public void put(String key, Employee e){
        int hashedKey = hashKey(key);
        hashtable[hashedKey].add(new StoredEmployee(key,e));
    }

    public Employee get(String key){
        int hashedKey = hashKey(key);
        ListIterator<StoredEmployee> iterator = hashtable[hashedKey].listIterator();
        StoredEmployee employee = null;
        while(iterator.hasNext()){
            employee = iterator.next();
            if(employee.key.equals(key)){
                return employee.employee;
            }
        }
        return null;
    }

    public Employee remove(String key){
        int hashedKey = hashKey(key);
        ListIterator<StoredEmployee> iterator = hashtable[hashedKey].listIterator();
        StoredEmployee employee = null;
        int index = -1;
        while(iterator.hasNext()){
            employee = iterator.next();
            index++;
            if(employee.key.equals(key)){
                break;
            }
        }
        if(employee == null) {
            return null;
        }else{
            hashtable[hashedKey].remove(index);
            return employee.employee;
        }
    }

    private int hashKey(String key){
        return Math.abs(key.hashCode() % hashtable.length);
    }

    public void printHashtable(){
        for(int i=0;i<hashtable.length;i++){
            if(hashtable[i].isEmpty()){
                System.out.println("Position " +i+": empty");
            }
            else{
                System.out.println(("Position" +i+": "));
                ListIterator<StoredEmployee> iterator = hashtable[i].listIterator();
                while(iterator.hasNext()) {
                    System.out.print(iterator.next().employee);
                    System.out.print("->");
                }
                System.out.print("null");
            }
        }
    }

    public static void main(String[] args) {
        ChainHashtable ht = new ChainHashtable();
        Employee emp1 = new Employee(122,"Harvey Spector",63000);
        Employee emp2 = new Employee(123,"Mike Ross",80000);
        Employee emp3 = new Employee(124,"Jessica Pearson",75000);
        Employee emp4 = new Employee(125,"rachel Zane",50000);
        Employee emp5 = new Employee(126,"Lious Litt",50000);

        ht.put("Harvey",emp1);
        ht.put("Mike",emp2);
        ht.put("Jessica",emp3);
        ht.put("Rachel",emp4);

        ht.printHashtable();

        System.out.print("retrive key Harvey" + ht.get("Harvey"));

        ht.remove("Mike");
        ht.remove("Rachel");
        ht.printHashtable();

    }
}
