package design_patterns.factory.products;

public class IosButton implements Button{
    @Override
    public void click() {
        System.out.println("Clicking IOS Button");
    }
}
