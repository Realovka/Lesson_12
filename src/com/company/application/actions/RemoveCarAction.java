package com.company.application.actions;

import com.company.application.utils.Input;

public class RemoveCarAction extends BaseAction implements Action {
    @Override
    public String getName() {
        return "Удалить автомобиль";
    }

    @Override
    public void action() {
       int id= Input.getInt("Введите ID");
       carController.remove(id);
    }
}
