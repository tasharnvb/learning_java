package com.company;

/**
 * Created by Academy07 on 02/08/2016.
 */
public class Email {
    private String from;
    private String to;
    private String message;
    public Email() {

    }

    public Email(String from, String to, String message) {
        this.from = from;
        this.to = to;
        this.message = message;
    }

    public int charactersInMessage() {
        return getMessage().length();
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
