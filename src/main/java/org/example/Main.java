package org.example;

import db.DBUtils;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        Context globalContext = Context.getInstance();

        globalContext.getTenant();

        System.out.print("Hello and welcome!");
        Session session = DBUtils.getCurrentSession();
        DBUtils.shutdown();
    }
}