package threads.demo2;

public class OddPrinter implements Runnable{
    @Override
    public void run() {
        for (int i=0; i<50; i++){
            if(i%2!=0){
                System.out.println("I am odd:" + i);
            }
        }
    }
}
