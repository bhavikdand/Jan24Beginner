package streams;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,23,50,456,32,756,4,346,8,9,80);

        list.stream()
                .filter(x -> x%2==1)
                .forEach(y -> System.out.println(y));

        for(int i: list){
            if(i%2==1){
                System.out.println(i);
            }
        }

        // Out of the given list, create a new list of only even numbers
        List<Integer> evenList = list.stream()
                .filter(x -> x%2==0) // Filters as per the given logic
                .collect(Collectors.toList()); // Converts the stream back to desired format

//        List<Integer> even = new ArrayList<>();
//        for(int i: list){
//            if(i%2==0){
//                even.add(i);
//            }
//        }

        System.out.println("Even:" + evenList);

        // I want to count even numbers greater than 100 in this list
        long count = list.stream()
                .filter(num -> num % 2 == 0 && num > 100)
                .count();
        System.out.println(count);

        List<String> names = Arrays.asList("Bhavik", "Ravalika", "Vrushali", "Shashank", "Mohan", "Bhavna");
        // Create a new list where each element is the size of the string in the original list

        List<Integer> sizeOfNames = names.stream()
                .map(name -> name.length()) // Changes the data or change the data type
                .collect(Collectors.toList());

        System.out.println("Size of names:" + sizeOfNames);

        // Create a new list where each element contains first 2 chars of the name
        List<String> first2Chars= names.stream()
                .map(name -> name.substring(0, 2))
                .collect(Collectors.toList());

        System.out.println("First 2 chars:" + first2Chars);

        // Filter names starting with "B" and count the number of characters in them and
        // create a new list out of it
        List<Integer> sizeOfNamesWithB = names.stream()
                .filter(name -> name.charAt(0) == 'B')
                .map(name -> name.length())
                .collect(Collectors.toList());

        System.out.println(sizeOfNamesWithB);

        // Sort the even elements in the list
        List<Integer> sortedEvenNumbers = list.stream()
                .filter(n -> n % 2 == 0)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(sortedEvenNumbers);

        // For all the odd numbers, take a square and create a new list out of it
        List<Integer> oddSquares = list.stream()
                .filter(n -> n % 2 == 1)
                .map(n -> n * n)
                .collect(Collectors.toList());

        System.out.println(oddSquares);

        List<Student> students = Arrays.asList(new Student("Bhavik", 27), new Student("John", 20), new Student("Jane", 30));
        List<String> studentNames = students.stream()
                .map(student -> student.getName())
                .collect(Collectors.toList());

        System.out.println(studentNames);

        // Lambdas follow lazy evaluation i.e. until a terminal operation
        // is called lambda, intermediate operations wont be executed
        // Because they consider the terminal operation, can I say that they improve
        // their performance?  Yes

        List<Integer> sqEven = list.stream()
                .filter(x -> {
//                    System.out.println("I am filter:" + x);
                    return x % 2 == 0;
                })
                .map(n -> {
//                    System.out.println("I am in map:" + n);
                    return n * n;
                })
                .distinct()
                .collect(Collectors.toList());

        System.out.println("---------");
        List<Integer> li = Arrays.asList(1,3,5,7,9, 10, 12);
        Optional<Integer> oi = li.stream()
                .filter(x -> {
                    System.out.println("I am filter:" + x);
                    return x % 2 == 0;
                })
                .findFirst();

        for(int num : li){
            if(num%2==0){
                System.out.println(num);
                break;
            }
        }


        if(oi.isPresent()){
            System.out.println(oi.get());
        } else {
            System.out.println("Data is missing");
        }

        Stream<Object> a = Stream.of("A", 1, 1.0);
    }
}

class Student{
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
}
