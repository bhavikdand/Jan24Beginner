package design_patterns.factory;

import design_patterns.factory.products.Button;
import design_patterns.factory.products.Menu;

public class Client {

    public static void main(String[] args) {
        UIFactory uiFactory = Flutter.getUIFactoryByPlatform(Platform.ANDROID);
        Menu menu = uiFactory.createMenu();
        menu.render();
        Button button = uiFactory.createButton();
        button.click();
    }
}
