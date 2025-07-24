package streamApi;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class pStream {


    public static void main(String[] args) {
        //creating a supplier
        Supplier<String> supplier = () -> "Hello World !";

        //creating a consumer
        Consumer<String> consumer = str -> System.out.println("print String :"+str);

        //generating and consuming
//        Stream<String> stringstream = Stream.generate(supplier);
//        stringstream.forEach(consumer);



        Stream.of(1,2,3,4,5,6,7,8,9,0).forEach(integer->System.out.println("value is "+integer));
        List<String> codes = Arrays.asList("Alpha","Bravo","Charlie","Delta","Foxtrot","Echo","Golf","Hotel","India","Juliet");


        System.out.println("+++++++++++++++++++++Stream Creation++++++++++++++++++++++++");

        //general stream
        Stream<String> codesStream=codes.stream();
        //expected output {"Alpha","Bravo","Charlie","Delta","Foxtrot","Echo","Golf","Hotel","India","Juliet"}

        //from values
        Stream<String> values = Stream.of("One","Two","Three");
        //expected output {one,two,three}

        //empty stream
        Stream<String> emptyStream = Stream.empty();
        //expected output {}

        //infinite stream
        Stream<Integer> infiniteStream = Stream.generate(()->1).limit(3);
        //expected output {1,1,1}

        // iterated stream
        Stream<Integer> interatedStream =Stream.iterate(1,n->n+2).limit(3);
        //expected output {1,3,5}

        System.out.println("+++++++++++++++++++++Intermediate Operations++++++++++++++++++");

        //filter(predicate) :filters elements based on predicate
        List<String> Acodes = codes.stream()
                                    .filter(str->str.startsWith("A"))
                                    .collect(Collectors.toList());
        System.out.println(Acodes);

        //map() :maps elements based on the value it takes
        List<Integer> mapped = codes.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println("value is :"+mapped);

        //flatmap() : combines multiple streams in to a single stream
        List<String> characterStream = codes.stream()
                .flatMap(code->Arrays.stream(code.split("")))
                .collect(Collectors.toList());
        System.out.println("value is :"+characterStream);

        //distinct() :gives distinct elements
        List<String> DistinctStream = codes.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("value is :"+DistinctStream);

        //sort() :sorts in natural order
        List<String> sortedStream = codes.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("value is :"+sortedStream);

        //sort(comparator) :using defined comparator
        List<String> comparatorsortedStream = codes.stream()
                .sorted((a,b)->Integer.compare(b.length(),a.length()))
                .collect(Collectors.toList());
        System.out.println("value is :"+comparatorsortedStream);

        //peek() view element in stream
         codes.stream()
                .peek(n->System.out.println("peeking the value:" +n))
                .limit(3)
                .forEach(n->{});


        //limit() limit number of elements
        List<String> limitstring = codes.stream()
                .limit(5)
                .collect(Collectors.toList());
        System.out.println("value is "+limitstring);

        List<String> skippedlist = codes.stream()
                .skip(2)
                .collect(Collectors.toList());
        System.out.println("value is "+skippedlist);

        //takeWhile(condition) check for condition
        List<Integer> whileStream = Arrays.asList(1,2,3,4,5,6,7,8,9,0).stream()
                .takeWhile(n->n<5)
                .collect(Collectors.toList());
        System.out.println("value is "+whileStream);

        //dropWhile(condition) drops if condition true
        List<Integer> dropwhileStream = Arrays.asList(1,2,3,4,5,6,7,8,9,0).stream()
                .dropWhile(n->n<5)
                .collect(Collectors.toList());
        System.out.println("value is "+dropwhileStream);

        System.out.println("=============================================terminal Operations=========================================");

        //forEach() checks for each elemewnt
        codes.stream().forEach(n->System.out.println(n));

        //toArray() : convert to Array
        String[] codeArr = codes.stream().toArray(String[]::new);
        System.out.println(codeArr);

        //reduce() : reduces to a single stream

        Optional<String> reducedStrinng = codes.stream().reduce((a, b)->a+", "+b);

        reducedStrinng.ifPresent(n->System.out.println(n));

        //collect() :collects elements to using
        Map<Integer,List<String>> collectedgrouping = codes.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(collectedgrouping);

        //min max
        Optional<String> minelement = codes.stream().min(Comparator.comparing(String::length));
        Optional<String> maxelement = codes.stream().max(Comparator.comparing(String::length));

        System.out.println("min string is ::"+minelement.orElse("N/A"));
        System.out.println("min string is ::"+maxelement.orElse("N/A"));

        //count
        System.out.println("count of elements is :"+codes.stream().count());

        //anyMatch(),allMatch(),noneMatch()
        System.out.println("using anymatch for A"+codes.stream().anyMatch(s->s.startsWith("A")));
        System.out.println("using all match for length > 1 : "+codes.stream().allMatch(s->s.length()>1));
        System.out.println("using nonematch for name Bravo : "+codes.stream().noneMatch(s->s=="Bravo"));

        //findFirst() findAny()
        System.out.println("using findFirst : "+codes.stream().findFirst().orElse("N/A"));
        System.out.println("using findAny : "+codes.stream().findAny().orElse("N/A"));

        System.out.println("======================Primitive Operations========");
        //paralllel stream
        System.out.println("using parallel streams : "+codes.parallelStream().sorted().collect(Collectors.toList()));

        //custom collector
        Collector<String,StringBuilder,String>  customcollector = Collector.of(
                StringBuilder::new,
                (sb,s)->sb.append(s).append("|"),
                StringBuilder::append,
                StringBuilder::toString
        );

        System.out.println("using custom collector"+codes.stream().collect(customcollector));

        System.out.println("======================using string Concatination=====================");

        Stream<String> stream1 = Stream.of("A","B");
        Stream<String> stream2 = Stream.of("C","D");
        System.out.println(Stream.concat(stream1,stream2).collect(Collectors.toList()));

        //intermediate operations


        
        // |------>stateless statefull
        //Terminal Operations
















    }
}
