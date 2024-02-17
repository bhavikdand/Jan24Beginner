package design_patterns.adapter;

public class Client {

    public static void main(String[] args) {
        EmailHelper emailHelper = new EmailHelper(new SendgridAdapter());
        emailHelper.sendEmail("bhavik@scaler.com", "admin@scaler.com", "Hello!");
    }
}
