package threads.demo2;

public class Example {

    public static void main(String[] args) {
        OddPrinter op = new OddPrinter();
        EvenPrinter ep = new EvenPrinter();

        Thread opt = new Thread(op);
        Thread ept = new Thread(ep);

        opt.start();
        ept.start();
    }
}
