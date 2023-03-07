package org.fk.vs.data;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
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
}
