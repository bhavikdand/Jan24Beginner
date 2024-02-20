package design_patterns.decorator;

public class Main {

    public static void main(String[] args) {
        Ingredient icecream =
                new ChocoChip(
                    new StrawberrySyrup(
                        new MangoScoop(
                            new ChocoCone()
                        )
                    )
                );

        System.out.println(icecream.getCost());
        System.out.println(icecream.getDescription());
    }
}
