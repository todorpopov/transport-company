package org.example;

import db.DBUtils;
import db.entities.client.Client;
import db.entities.client.ClientDAO;
import db.entities.client.ClientService;
import db.entities.client.dtos.ClientMapper;
import db.entities.client.dtos.CreateClientDTO;
import db.entities.company.Company;
import db.entities.company.CompanyDAO;
import db.entities.company.CompanyService;
import db.entities.company.dtos.CompanyMapper;
import db.entities.company.dtos.CreateCompanyDTO;


public class Main {
    public static void main(String[] args) {
        ClientDAO clientDAO = new ClientDAO();
        ClientService clientService = new ClientService(clientDAO);

        CompanyDAO companyDAO = new CompanyDAO();
        CompanyService companyService = new CompanyService(companyDAO);

        Client client = new Client("Speedy", false);
        Company company = new Company("Microsoft");

        CreateClientDTO createClient = ClientMapper.toCreateDTO(client);
        CreateCompanyDTO createCompany = CompanyMapper.toCreateDTO(company);

        clientService.saveOne(createClient);
        companyService.saveOne(createCompany);

        DBUtils.shutdown();
    }
}