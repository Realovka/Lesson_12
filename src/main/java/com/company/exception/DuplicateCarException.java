package com.company.exception;

public class DuplicateCarException extends Exception {
    private int id;
    public DuplicateCarException(int id){
        this.id=id;
    }

    @Override
    public String getMessage() {
        return "Автомобиль с таким id "+id+" уже существует";
    }
}
