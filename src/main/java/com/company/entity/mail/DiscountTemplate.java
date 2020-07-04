package com.company.entity.mail;

public class DiscountTemplate implements Template{
    private String name;

    public DiscountTemplate(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getText() {
        return String.format("Уважаемый %s. У нас скидки на всё 30 процентов. Ждем вас!", name);
    }
}
