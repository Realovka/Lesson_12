package com.company.dao;


import com.company.entity.Subscriber;

import java.util.Arrays;
import java.util.List;



public class MemorySubscriberDao implements SubscribersDao{
    @Override
    public  List<Subscriber> get() {
        return Arrays.asList(
                new Subscriber("Петя", "petya@mail.ru"),
                new Subscriber("Женя", "zhenya@mail.ru"),
                new Subscriber("Вася", "vasya@mail.ru"),
                new Subscriber("Коля", "kolya@mail.ru"),
                new Subscriber("Саша", "sacsha@mail.ru")

        );
    }
}

