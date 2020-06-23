package com.company.application.actions;


import com.company.application.exception.StopApplicationException;

public interface Action {

    String getName();
    void action() throws StopApplicationException;
}
