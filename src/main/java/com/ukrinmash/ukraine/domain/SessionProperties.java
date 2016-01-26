package com.ukrinmash.ukraine.domain;

import org.springframework.stereotype.Component;

@Component
public class SessionProperties {

    private int attempt = 5;

    private String sessionUserName;

    public SessionProperties(String name) {
        this.sessionUserName = name;
    }

    public void setSessionUserName(String sessionUserName) {
        this.sessionUserName = sessionUserName;
    }

    public SessionProperties() {
    }

    public SessionProperties(int attempt) {
        this.attempt = attempt;
    }

    public void setAttempt(int attempt) {
        this.attempt = attempt;
    }

    public int getAttempt() {
        return attempt;
    }

    public String getName() {
        return sessionUserName;
    }
}

