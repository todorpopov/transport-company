package org.example;

import db.DBUtils;
import db.entities.company.CompanyDAO;
import db.entities.company.CompanyDTO;

public class Main {
    public static void main(String[] args) {
        Context globalContext = Context.getInstance();

        globalContext.getTenant();

        CompanyDTO dto = new CompanyDTO(null, "Microsoft", null, null, null, null);
        CompanyDAO.save(CompanyDTO.toEntity(dto));
        DBUtils.shutdown();
    }
}