package org.example;

import db.DBUtils;

import exceptions.InvalidFreighException;

public class Main {
    public static void main(String[] args) throws InvalidFreighException {
        Context globalContext = Context.getInstance();

        globalContext.getTenant();


        DBUtils.shutdown();
    }
}