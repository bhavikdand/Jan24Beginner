package abstract_demo;

public class Example {
    public static void main(String[] args) {
        // Animal a = new Animal(); // Animal is abstract
        Animal a = new Dog();
        a.walk();

        // ABC abc = new ABC();
    }
}

abstract class Animal{
    String name;
    int age;

    public void printName(){
        System.out.println(name);
    }

    abstract void walk();
}

class Dog extends Animal{
    String breed;

    @Override
    void walk() {
        System.out.println("dog is walking");
    }
}

// An abstract class can have 0 abstract methods as well.
abstract class ABC{
    String a;
    int b;

}

