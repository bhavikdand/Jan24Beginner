package generics.intro;

public class DoublePrinter {

    Double doubleToPrint;

    public DoublePrinter(Double doubleToPrint) {
        this.doubleToPrint = doubleToPrint;
    }
    public void print(){
        System.out.println(doubleToPrint);
    }
}
