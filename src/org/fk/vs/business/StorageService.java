package org.fk.vs.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

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

    public List<Vehicle> getReservedVehicles()
    {
        List<Entry<Integer, Vehicle>> resultList = vehicleList.entrySet().stream().filter(item -> item.getValue().getStatus() == Status.Reserved).toList();
        List<Vehicle> reservedList = new ArrayList<>();
        
        // TODO check for empty values

        for (Entry<Integer,Vehicle> entry : resultList) {
            reservedList.add(entry.getValue());    
        }

        return reservedList;
    }
}
