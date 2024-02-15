package design_patterns.factory.products;

public class AndroidButton implements Button{
    @Override
    public void click() {
        System.out.println("Clicking android button");
    }
}
