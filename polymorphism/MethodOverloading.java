package polymorphism;

public class MethodOverloading {
    public static void main(String[] args) {
        Printer p = new Printer();
        p.print();
        p.print("Hi");
    }
}

class Printer{
    public void print(){
        System.out.println("No args");
    }

    public void print(String s){
        System.out.println("s: "+s);
    }
}
