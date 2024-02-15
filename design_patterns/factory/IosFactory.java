package design_patterns.factory;

import design_patterns.factory.UIFactory;
import design_patterns.factory.products.IosButton;
import design_patterns.factory.products.IosMenu;

public class IosFactory implements UIFactory {
    @Override
    public IosButton createButton() {
        return new IosButton();
    }

    @Override
    public IosMenu createMenu() {
        return new IosMenu();
    }
}
