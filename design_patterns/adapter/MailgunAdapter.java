package design_patterns.adapter;

import design_patterns.adapter.libraries.Mailgun;

public class MailgunAdapter implements EmailAdapter{

    Mailgun client = new Mailgun();


    @Override
    public void sendEmail(String to, String from, String content) {
        client.send(to, from, content, null, null);
    }
}
