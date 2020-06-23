package com.company.application;

import com.company.application.actions.Action;
import com.company.application.exception.StopApplicationException;
import com.company.application.utils.Input;
import com.company.exception.DuplicateCarException;

import java.util.Map;

public class ConsoleApplication {

    public static void start(){
        System.out.println("Привет");
        run();
        System.out.println("Пока");
    }

    private static void run(){
        while (true){
          Action action=getAction();

            try {
                action.action();
            } catch (StopApplicationException e) {
                break;
            }

        }
    }

    private static void showMenu(){
        for(Map.Entry<Integer, Action> action: Config.actions.entrySet()){
            System.out.println(action.getKey()+"-"+action.getValue().getName());
        }
    }

    private static Action getAction(){
        showMenu();
        int number= Input.getInt("Выберите действие");
        Action action = Config.actions.get(number);
        if(action!=null){
            return action;
        }
        System.out.println("Нет такого действия. Повторите ввод.");
        return getAction();
    }
}
