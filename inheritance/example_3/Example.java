package inheritance.example_3;

public class Example {

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

    public B(String s) {
        System.out.print("B:" + s);
    }
}

class C extends B{

    public C() {
        super("Hello");
        System.out.print("C");
    }
}

