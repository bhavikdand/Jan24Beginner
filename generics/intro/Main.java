package generics.intro;

public class Main {

    public static void main(String[] args) {
        IntegerPrinter ip = new IntegerPrinter(23);
        ip.print();

        DoublePrinter dp = new DoublePrinter(23d);
        dp.print();

        ObjectPrinter iop = new ObjectPrinter(23);
        Integer i = (Integer) iop.get();
        ObjectPrinter dop = new ObjectPrinter(23d);

        ObjectPrinter sop = new ObjectPrinter("Hello");
        Integer j = (Integer) sop.get();
    }
}
