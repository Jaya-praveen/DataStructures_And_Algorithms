package datastructures.customdatastructures;

import utils.Employee;
import utils.StoredEmployee;

public class HashMaps<E> {

    private StoredEmployee[] hashTable ;

    public HashMaps(int capacity){

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

    public int hashKey(String key){
        return key.length()%hashTable.length;
    }

    public static void main(String[] args) {


    }
}
