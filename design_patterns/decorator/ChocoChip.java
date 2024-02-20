package design_patterns.decorator;

public class ChocoChip extends IngredientDecorator{

    public ChocoChip(Ingredient baseIngredient) {
        super(baseIngredient);
    }


    @Override
    public double getCost() {
        return baseIngredient.getCost() + 15;
    }

    @Override
    public String getDescription() {
        return baseIngredient.getDescription() + ", Choco chips";
    }
}
