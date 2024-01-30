package object_methods;

import interfaces.Animal;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        AnimalA a = new AnimalA("Dog", 5);
        System.out.println(a.toString());

        AnimalA b = new AnimalA("Dog", 5);
//        System.out.println(a.equals(b));
//        System.out.println(a == b);
//        System.out.println(a == a);
//        System.out.println(a.equals("String"));

        AnimalA c = new AnimalA("Cat", 10);
        AnimalA d = new AnimalA("Cat", 10);


        Set<AnimalA> set = new HashSet<>();
        set.add(a);
        set.add(b);
        set.add(c);
        set.add(d);
        System.out.println(set.size());
    }
}

class AnimalA{
    String name;
    int age;

    public AnimalA(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString(){
        return "Name:" + name +",age:" +age;
    }

//    @Override
//    public boolean equals(Object obj){
//        if(obj instanceof AnimalA){
//            AnimalA newAnimal = (AnimalA) obj;
//            return newAnimal.name.equals(this.name) && newAnimal.age == this.age;
//        }
//        else {
//            return false;
//        }
//
//    }
//
//    @Override
//    public int hashCode() {
//        return this.name.hashCode() + this.age;
//    }
}
