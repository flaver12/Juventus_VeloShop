package org.fk.vs.business.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.fk.vs.data.enums.Status;
import org.fk.vs.data.interfaces.User;
import org.fk.vs.data.interfaces.Vehicle;

public class StorageService {
    private HashMap<Integer, Vehicle> vehicleList = new HashMap<Integer, Vehicle>();
    private VehicleService vehicleService;
    private UserService userService;

    public StorageService(VehicleService vehicleService, UserService userService) {
        this.userService = userService;
        this.vehicleService = vehicleService;
    }

    public void reserveVehicle(User user, Vehicle vehicle) {
        // Do we have this?
        if (!vehicleService.doesVehicleExist(vehicle)) {
            return; // Do nothing
        }

        vehicle.setStatus(Status.Reserved);
        vehicleList.put(user.getId(), vehicle);
    }

    public List<Entry<Integer, Vehicle>> getReservedVehicles()
    {
        List<Entry<Integer, Vehicle>> resultList = vehicleList.entrySet().stream().filter(item -> item.getValue().getStatus() == Status.Reserved).toList();
        return resultList;
    }
}
