package design_patterns.adapter.libraries;

public class Mailgun {

    public void send(String to, String from, String content, String[] cc, String[] bcc){
        System.out.println("Sending email via mailgun");
    }
}
