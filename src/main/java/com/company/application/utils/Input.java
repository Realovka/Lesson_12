package com.company.application.utils;

import java.util.Scanner;

public class Input {
    private static Scanner scanner=new Scanner(System.in);

    public static int getInt(){
        if(scanner.hasNextInt()){
            int a=scanner.nextInt();
            scanner.nextLine();
            return  a;
        }
        System.out.println(scanner.nextLine()+" -это не целое число. Повторите ввод.");
        return getInt();
    }

    public static int getInt(String message){
        System.out.println(message);
        return getInt();
    }

    public static String getString(){
        return scanner.nextLine();
    }

    public static String getString(String message){
        System.out.println(message);
        return getString();
    }
}
