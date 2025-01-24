package org.example;

import db.entities.company.CompanyDTO;
import db.entities.driver.DriverDTO;
import db.entities.freight.FreightDTO;
import db.entities.vehicle.VehicleDTO;

public class Context {
    private static Context instance;

    private CompanyDTO currentCompany;

    private DriverDTO currentDriver;

    private FreightDTO currentFreight;

    private VehicleDTO currentVehicle;

    private Context() {
    }

    public static Context getInstance() {
        if (instance == null) {
            instance = new Context();
        }

        return instance;
    }

    public CompanyDTO getCurrentCompany() {
        return currentCompany;
    }

    public void setCurrentCompany(CompanyDTO company) {
        this.currentCompany = company;
    }

    public void resetCurrentCompany() {
        this.currentCompany = null;
    }

    public DriverDTO getCurrentDriver() {
        return currentDriver;
    }

    public void setCurrentDriver(DriverDTO driver) {
        this.currentDriver = driver;
    }

    public void resetCurrentDriver() {
        this.currentDriver = null;
    }

    public FreightDTO getCurrentFreight() {
        return currentFreight;
    }

    public void setCurrentFreight(FreightDTO freight) {
        this.currentFreight = freight;
    }

    public void resetCurrentFreight() {
        this.currentFreight = null;
    }

    public VehicleDTO getCurrentVehicle() {
        return currentVehicle;
    }

    public void setCurrentVehicle(VehicleDTO vehicle) {
        this.currentVehicle = vehicle;
    }

    public void resetCurrentVehicle() {
        this.currentVehicle = null;
    }

    public void getTenant() {

    }
}
