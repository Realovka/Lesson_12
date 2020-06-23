package com.company.application.config;

import com.company.application.actions.*;

import java.util.HashMap;
import java.util.Map;

public class Config {

    public static Map<Integer, Action> actions =new HashMap<>();

    static {
        actions.put(1, new AddCarAction());
        actions.put(2, new ShowCarAction());
        actions.put(3, new RemoveCarAction());
        actions.put(4, new UpdateCarAction());
        actions.put(0, new StopApplicationAction());
    }
}
