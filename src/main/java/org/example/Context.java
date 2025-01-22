package org.example;

import db.entities.company.CompanyDTO;

public class Context {
    private static Context instance;

    private CompanyDTO company;

    private Context() {}

    public static Context getInstance() {
        if (instance == null) {
            instance = new Context();
        }

        return instance;
    }

    public CompanyDTO getCompany() {
        return company;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }

    public void getTenant() {

    }
}
