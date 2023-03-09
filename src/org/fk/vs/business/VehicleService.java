package org.fk.vs.business;

import java.util.ArrayList;
import java.util.List;

import org.fk.vs.data.Vehicle;

public class VehicleService {
    
    private List<Vehicle> vehicles = new ArrayList<Vehicle>();

    public void AddVehicle(Vehicle vehicle) {
        if (this.vehicles.contains(vehicle)) {
            return;
        }

        this.vehicles.add(vehicle);
    }

    public void RemoveVehicle(Vehicle vehicle) throws Exception {
        if (!this.vehicles.contains(vehicle)) {
            throw new Exception("Vehicle is not in list");
        }

        this.vehicles.remove(vehicle);
    }

    public List<Vehicle> getVehicles() {
        return this.vehicles;
    }

    public boolean doesVehicleExist(Vehicle vehicle) {
        return this.vehicles.contains(vehicle);
    }
}
