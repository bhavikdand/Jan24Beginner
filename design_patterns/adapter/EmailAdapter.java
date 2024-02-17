package design_patterns.adapter;

public interface EmailAdapter {

    void sendEmail(String to, String from, String content);
}
