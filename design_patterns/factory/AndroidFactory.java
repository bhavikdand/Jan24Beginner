package design_patterns.factory;

import design_patterns.factory.products.AndroidButton;
import design_patterns.factory.products.AndroidMenu;
import design_patterns.factory.products.Button;
import design_patterns.factory.products.Menu;

public class AndroidFactory implements UIFactory{
    @Override
    public AndroidButton createButton() {
        return new AndroidButton();
    }

    @Override
    public AndroidMenu createMenu() {
        return new AndroidMenu();
    }
}
