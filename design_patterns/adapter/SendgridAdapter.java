package design_patterns.adapter;

import design_patterns.adapter.libraries.Sendgrid;

public class SendgridAdapter implements EmailAdapter{

    Sendgrid client = new Sendgrid();


    @Override
    public void sendEmail(String to, String from, String content) {
        client.sendEmail(content, to, from, null, null);
    }
}
