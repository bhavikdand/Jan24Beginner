package design_patterns.adapter;

public class EmailHelper {

    EmailAdapter adapter;

    public EmailHelper(EmailAdapter adapter) {
        this.adapter = adapter;
    }

    public void sendEmail(String to, String from, String content){
        adapter.sendEmail(to, from, content);
    }
}
