package com.alibaba.reactive.mail;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * mail class
 *
 * @author leijuan
 */
public class Mail implements Serializable {
    private String sender;
    private List<String> receivers;
    private List<String> cc;
    private String subject;
    private String textBody;
    private String htmlBody;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public List<String> getReceivers() {
        return receivers;
    }

    public void setReceivers(List<String> receivers) {
        this.receivers = receivers;
    }

    public List<String> getCc() {
        return cc;
    }

    public void setCc(List<String> cc) {
        this.cc = cc;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTextBody() {
        return textBody;
    }

    public void setTextBody(String textBody) {
        this.textBody = textBody;
    }

    public String getHtmlBody() {
        return htmlBody;
    }

    public void setHtmlBody(String htmlBody) {
        this.htmlBody = htmlBody;
    }

    public Mail simple(String sender, String receiver, String subject, String htmlBody) {
        Mail mail = new Mail();
        mail.setSender(sender);
        mail.setReceivers(Collections.singletonList(receiver));
        mail.setSubject(subject);
        mail.setHtmlBody(htmlBody);
        return mail;
    }
}
