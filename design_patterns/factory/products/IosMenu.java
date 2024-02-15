package design_patterns.factory.products;

public class IosMenu implements Menu{
    @Override
    public void render() {
        System.out.println("Rendering IOS Menu");
    }
}
