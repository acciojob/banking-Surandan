package com.driver;

public class InsufficientBalance extends Exception{
    public InsufficientBalance(String str) {
        super(str);
    }
}
