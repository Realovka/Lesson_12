package com.company.entity.mail;

public class CongratulationTemplate implements Template {
    private String name;

    public CongratulationTemplate(String name) {
        this.name = name;
    }

    @Override
    public String getText() {
        return String.format("Уважаемый, %s, поздравляем с Новым годом!",name);
    }
}
