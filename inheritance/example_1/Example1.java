package inheritance.example_1;

public class Example1 {

    public static void main(String[] args) {
        C c = new C();
    }
}

class A{

    public A() {
        System.out.print("A");
    }
}

class B extends A{

    public B() {
        System.out.print("B");
    }
}

class C extends B{

    public C() {
        System.out.print("C");
    }
}

