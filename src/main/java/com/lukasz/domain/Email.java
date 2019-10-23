package com.lukasz.domain;

import com.google.common.base.Objects;

public class Email {

    private String recipientEmail;
    private String message;

    Email() {
        //for jackson
    }

    private Email(String recipientEmail, String message) {
        this.recipientEmail = recipientEmail;
        this.message = message;
    }

    public static Email of(String recipientEmail, String message) {
        return new Email(recipientEmail, message);
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
        if (!(o instanceof Email)) return false;
        Email email = (Email) o;
        return Objects.equal(recipientEmail, email.recipientEmail) &&
                Objects.equal(message, email.message);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(recipientEmail, message);
    }
}
