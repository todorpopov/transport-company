package org.example;

import db.DBUtils;
import db.entities.client.ClientService;
import db.entities.company.CompanyService;
import db.entities.driver.DriverService;
import db.entities.freight.FreightService;
import db.entities.vehicle.VehicleService;


public class Main {
    public static void main(String[] args) {
        ClientService clientService = ClientService.getInstance();
        CompanyService companyService = CompanyService.getInstance();
        DriverService driverService = DriverService.getInstance();
        FreightService freightService = FreightService.getInstance();
        VehicleService vehicleService = VehicleService.getInstance();

        DBUtils.shutdown();
    }
}