package org.fk.vs.business;

import java.util.HashMap;

import org.fk.vs.data.Customer;
import org.fk.vs.data.Status;
import org.fk.vs.data.Vehicle;

public class StorageService {
    private HashMap<Integer, Vehicle> vehicleList = new HashMap<Integer, Vehicle>();
    private VehicleService vehicleService;
    private UserService userService;

    public StorageService(VehicleService vehicleService, UserService userService) {
        this.userService = userService;
        this.vehicleService = vehicleService;
    }

    public void reserveVehicle(Customer customer, Vehicle vehicle) {
        // Do we have this?
        if (!vehicleService.doesVehicleExist(vehicle)) {
            return; // Do nothing
        }

        vehicle.setStatus(Status.Reserved);
        vehicleList.put(vehicle.getId(), vehicle);
    }
}
