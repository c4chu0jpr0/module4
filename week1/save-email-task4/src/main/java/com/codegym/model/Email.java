package com.codegym.model;

public class Email {
    private String languages;
    private int size;
    private String spams, signature;

    public Email() {
    }

    public Email(String languages, int size, String spams, String signature) {
        this.languages = languages;
        this.size = size;
        this.spams = spams;
        this.signature = signature;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSpams() {
        return spams;
    }

    public void setSpams(String spams) {
        this.spams = spams;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
