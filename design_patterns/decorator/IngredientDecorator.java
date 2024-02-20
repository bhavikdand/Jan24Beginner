package design_patterns.decorator;

public abstract class IngredientDecorator implements Ingredient {

    Ingredient baseIngredient;

    public IngredientDecorator(Ingredient baseIngredient) {
        this.baseIngredient = baseIngredient;
    }
}
