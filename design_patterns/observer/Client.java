package design_patterns.observer;

public class Client {

    public static void main(String[] args) {
        InventoryPlaceOrderEventHandler inventoryPlaceOrderEventHandler = new InventoryPlaceOrderEventHandler();
        SellerPlaceOrderEventHandler sellerPlaceOrderEventHandler = new SellerPlaceOrderEventHandler();

        Publisher.getInstance().placeOrder();

        sellerPlaceOrderEventHandler.unregister();
        System.out.println("-------");
        Publisher.getInstance().placeOrder();
    }
}
