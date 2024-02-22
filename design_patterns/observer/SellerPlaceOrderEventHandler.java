package design_patterns.observer;

public class SellerPlaceOrderEventHandler implements EventHandler{

    public SellerPlaceOrderEventHandler(){
        Publisher.getInstance().register(this);
    }

    @Override
    public void handle() {
        System.out.println("Seller is deducting the inventory");
    }

    public void unregister(){
        Publisher.getInstance().unregister(this);
    }
}
