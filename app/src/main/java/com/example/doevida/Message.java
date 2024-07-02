package com.example.doevida;

public class Message {
    private String message;
    private boolean sentByMe;

    public Message(String message, boolean sentByMe) {
        this.message = message;
        this.sentByMe = sentByMe;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSentByMe() {
        return sentByMe;
    }
}
