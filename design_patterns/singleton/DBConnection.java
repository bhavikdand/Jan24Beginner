package design_patterns.singleton;

public class DBConnection {

    private DBConnection(){

    }
    private static DBConnection INSTANCE = null;

    public static DBConnection getInstance(){
        if(INSTANCE == null){
//            synchronized (DBConnection.class){
//                if(INSTANCE == null){
                    INSTANCE = new DBConnection();
//                }
//            }
        }
        return INSTANCE;
    }
}
