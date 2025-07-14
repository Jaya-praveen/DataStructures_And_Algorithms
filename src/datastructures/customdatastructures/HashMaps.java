package datastructures.customdatastructures;

import utils.Employee;
import utils.StoredEmployee;

public class HashMaps {

    private StoredEmployee[] hashTable ;

    public HashMaps(){

        this.hashTable = new StoredEmployee[10];
    }

    public void put(String key, Employee e){
      int hashedKey = hashKey(key);
      if(occupied(hashedKey)){
          int stopIndex = hashedKey;
          if(hashedKey==hashTable.length-1){
              hashedKey = 0;
          }else{
              hashedKey = hashedKey + 1;
          }
          while(hashedKey!=stopIndex&&occupied(hashedKey)){
              hashedKey = (hashedKey+1)%hashTable.length;
          }
      }

      if(occupied(hashedKey)){
          System.out.println("cannot add element to table");
      }else{
          hashTable[hashedKey] = new StoredEmployee(key,e);
      }


    }

    public Employee get(String key) {
        int hashedKey = findKey(key);
        if(hashedKey == -1) {
            return null;
        }
        return hashTable[hashedKey].employee;
    }

    public Employee remove(String key){
        int hashedKey = findKey(key);
        if(hashedKey == -1){
            return null;
        }
        Employee employee = hashTable[hashedKey].employee;
        hashTable[hashedKey] = null;

        StoredEmployee[] oldHashtable = hashTable;
        hashTable = new StoredEmployee[oldHashtable.length];
        for(int i=0;i<oldHashtable.length;i++) {
            if (oldHashtable[i] != null) {
                put(oldHashtable[i].key, oldHashtable[i].employee);
            }
        }
        return employee;
    }

    private int findKey(String key) {
        int hashedKey = hashKey(key);
        if (hashTable[hashedKey] != null && hashTable[hashedKey].key.equals(key)) {
            return hashedKey;
        }
        int stopIndex = hashedKey;
        if (hashedKey == hashTable.length - 1) {
            hashedKey = 0;
        } else {
            hashedKey++;
        }
        while (hashedKey != stopIndex && hashTable[hashedKey] != null && !hashTable[hashedKey + 1].key.equals(key)) {
            hashedKey = (hashedKey + 1) % hashTable.length;
        }
        if (hashTable[hashedKey] != null && hashTable[hashedKey].key.equals(key)) {
            return hashedKey;
        } else {
            return -1;
        }
    }
    public boolean occupied(int key){
       return hashTable[key]!=null;
    }

    private int hashKey(String key){
        return key.length()%hashTable.length;
    }

    public void printHashTable(){
        for(int i=0;i<hashTable.length;i++){
            if(hashTable[i] == null) {
                System.out.println("empty");
            }
            else{
                System.out.println("Position "+ i+"; "+hashTable[i].employee);
            }
        }
    }

    public static void main(String[] args) {

        Employee emp1 = new Employee(122,"Harvey Spector",63000);
        Employee emp2 = new Employee(123,"Mike Ross",80000);
        Employee emp3 = new Employee(124,"Jessica Pearson",75000);
        Employee emp4 = new Employee(125,"rachel Zane",50000);
        Employee emp5 = new Employee(126,"Lious Litt",50000);

        HashMaps ht = new HashMaps();
        ht.put("harvey",emp1);
        ht.put("Mike",emp2);
        ht.put("Jessica",emp3);
        ht.put("Rachel",emp4);

        ht.printHashTable();

        System.out.println("Retrieve key harvey "+ ht.get("harvey"));
        System.out.println("Retrieve key rachel"+ht.get("Rachel"));

        ht.remove("Mike");
        ht.remove("Jessica");
        ht.printHashTable();



    }
}
