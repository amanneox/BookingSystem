package com.api.api.model;

public enum SESFrom {

    ATTA("amanadhikari2@gmail.com", "Atta from My SES Test"),
    NO_REPLY("amanadhikari2@gmail.com", "My SES Test"),
    SUPPORT("support@mysestest.com", "My SES Support Support");

    private final String email;
    private final String name;

    private SESFrom(String email, String name) {
        this.email =email;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}