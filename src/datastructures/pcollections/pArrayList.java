package datastructures.pcollections;

import java.util.*;

public class pArrayList {

    public static void main(String[] args){
        List<String> names = new ArrayList<>();
        Collections.addAll(names,"Alpha","Beta","Charlie","Delta","Echo");

        System.out.println("Initial List: "+ names);

        //positional access
        System.out.println("Element at index 2: " +names.get(2));

        names.set(2,"Charly");
        System.out.println("After set() " + names);

        //bulk positions acces
        List<String> newNames = List.of("Fox","Gelileo");
        names.addAll(3,newNames);
        System.out.println("After addAll at index 3: " + names);

        System.out.println(("Contains 'Beta'" + names.contains("Beta")));
        System.out.println("Index of 'Gelileo " + names.indexOf("Gelileo"));
        names.add("Alpha");
        System.out.println("Last index of 'Alice' : " + names.lastIndexOf("Alpha"));

        System.out.println("Iterating using iterator:");
        Iterator<String> itr = names.iterator();
        while(itr.hasNext()){
            System.out.println((itr.next() + " "));

        }

        System.out.println("\n iterating using listIterator (both directions):");
        ListIterator<String> listItr =names.listIterator();
        while(listItr.hasNext()){
            System.out.println((listItr.next() + " "));

        }
        System.out.println();
        while(listItr.hasPrevious()){
            System.out.println((listItr.previous() + " "));

        }

        //range-view
        List<String> sub = names.subList(2,5);
        System.out.println("Sublist (index 2 to 4" + sub);
        sub.set(0,"Chnaged");
        System.out.println("Modified Subliust: " + sub);
        System.out.println("Original List after change: " + names);

        //Array conversion
        Object[] nameArray = names.toArray();
        System.out.println("Converted to Object[]: "+Arrays.toString((nameArray)));

        String[] strArray = names.toArray(new String[0]);
        System.out.println("Converted to String[]: " + Arrays.toString((strArray)));

        //java 8
        System.out.println("using forEach (Java 8): ");
        names.forEach(System.out::println);

        System.out.println("Filtered names (Java 8 Stream): ");
        names.stream()
                .filter(n -> n.startsWith("A"))
                .forEach(System.out::println);
        names.removeIf(name -> name.startsWith("B"));
        System.out.println("After removeif :" +names);

        names.sort(Comparator.naturalOrder());
        System.out.println("Sorted List: "+ names);

        List<String> java9List = List.of("X","Y","Z");
        System.out.println("Immutable List.of: "+ java9List);

        List<String> copied = List.copyOf(names);
        System.out.println("Immutable List.copyof"+ copied);






    }

}
