package design_patterns.decorator;

public class StrawberrySyrup extends IngredientDecorator{

    public StrawberrySyrup(Ingredient baseIngredient) {
        super(baseIngredient);
    }

    @Override
    public double getCost() {
        return baseIngredient.getCost() + 20;
    }

    @Override
    public String getDescription() {
        return baseIngredient.getDescription() + ", Strawberry syrup";
    }
}
