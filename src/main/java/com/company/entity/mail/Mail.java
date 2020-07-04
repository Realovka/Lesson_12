package com.company.entity.mail;

public class Mail {
    private String email;
    private Template template;

    public Mail(String email, Template template) {
        this.email = email;
        this.template = template;
    }

    public Mail() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }
}
