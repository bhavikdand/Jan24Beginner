package interfaces;

public class Dog implements Animal{

    public void eat() {
        System.out.println("Dog is eating");
    }
    public void walk() {
        System.out.println("Dog is walking");
    }

    public void run() {
        System.out.println("Dog is running");
    }
}