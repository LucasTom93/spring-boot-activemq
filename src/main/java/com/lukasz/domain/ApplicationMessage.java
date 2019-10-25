package com.lukasz.domain;

import com.google.common.base.Objects;

public class ApplicationMessage {

    private String recipientEmail;
    private String message;

    ApplicationMessage() {
        //for jackson
    }

    private ApplicationMessage(String recipientEmail, String message) {
        this.recipientEmail = recipientEmail;
        this.message = message;
    }

    public static ApplicationMessage of(String recipientEmail, String message) {
        return new ApplicationMessage(recipientEmail, message);
    }

    public String getRecipientEmail() {
        return recipientEmail;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Email{" +
                "recipientEmail='" + recipientEmail + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ApplicationMessage)) return false;
        var applicationMessage = (ApplicationMessage) o;
        return Objects.equal(recipientEmail, applicationMessage.recipientEmail) &&
                Objects.equal(message, applicationMessage.message);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(recipientEmail, message);
    }
}
