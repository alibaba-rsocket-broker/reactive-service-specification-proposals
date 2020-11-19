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
    private String from;
    private List<String> to;
    private List<String> cc;
    private String subject;
    private String textBody;
    private String htmlBody;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public List<String> getTo() {
        return to;
    }

    public void setTo(List<String> to) {
        this.to = to;
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

    public Mail simple(String from, String to, String subject, String htmlBody) {
        Mail mail = new Mail();
        mail.setFrom(from);
        mail.setTo(Collections.singletonList(to));
        mail.setSubject(subject);
        mail.setHtmlBody(htmlBody);
        return mail;
    }
}
