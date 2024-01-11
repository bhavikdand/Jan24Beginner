package polymorphism;

public class MethodOverloading2 {

    public static void main(String[] args) {
        AA aa = new CC();
        aa.print();
        aa = new BB();
        aa.print();
        aa = new AA();
        aa.print();

    }
}

class AA {
    void print(){
        System.out.println("A");
    }
}

class BB extends AA {
    void print(){
        super.print();
        System.out.println("B");
    }
}

class CC extends BB {
    void print(){
        System.out.println("C");
    }

    void print(String s){
        System.out.println(s);
    }
}
