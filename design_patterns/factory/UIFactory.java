package design_patterns.factory;

import design_patterns.factory.products.Button;
import design_patterns.factory.products.Menu;

public interface UIFactory {
    Button createButton();

    Menu createMenu();
}
