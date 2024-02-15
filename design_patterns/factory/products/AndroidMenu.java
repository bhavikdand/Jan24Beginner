package design_patterns.factory.products;

public class AndroidMenu implements Menu{
    @Override
    public void render() {
        System.out.println("Rendering Android Menu");
    }
}
