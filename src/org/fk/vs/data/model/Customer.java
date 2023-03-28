package org.fk.vs.data.model;

import java.util.ArrayList;
import java.util.List;

import org.fk.vs.data.AbstractUser;
import org.fk.vs.data.interfaces.Vehicle;

public class Customer extends AbstractUser {

    public Customer(int id, String name) {
        super(id, name);
    }

    private List<Vehicle> vehicles= new ArrayList<Vehicle>();
    private List<String> openBills = new ArrayList<String>();

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicles(Vehicle vehicle) {
        if (this.vehicles.contains(vehicle)) {
            return;
        }

        this.vehicles.add(vehicle);
    }

    @Override
    public String format() {
        return getName() + " is a Customer";
    }
}
