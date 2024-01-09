package inheritance.example_4;

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

    public B(){
        System.out.print("B");
    }

    public B(B og){

    }
}

class C extends B{

    public C() {
        super("Hi");
        //super(); //Call to 'super()' must be first statement in constructor body
        System.out.print("C");
    }

    public C(B b){
        super(b);
    }
}

