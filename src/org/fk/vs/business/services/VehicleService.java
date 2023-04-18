package org.fk.vs.business.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.fk.vs.data.interfaces.Vehicle;
import org.fk.vs.data.repository.VehicleRepository;

public class VehicleService {
    
    private List<Vehicle> vehicles = new ArrayList<Vehicle>();
	private VehicleRepository vehicleRepository = new VehicleRepository();

    public void AddVehicle(Vehicle vehicle) {

		vehicleRepository.insertVehicle(vehicle.toDao());
    }

    public void RemoveVehicle(Vehicle vehicle) throws Exception {
        if (!this.vehicles.contains(vehicle)) {
            throw new Exception("Vehicle is not in list");
        }

        this.vehicles.remove(vehicle);
    }

    public Collection<Vehicle> getVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle findVehicleById(int id)
    {
        return vehicleRepository.findById(id).toVehicle();
    }

    public boolean doesVehicleExist(Vehicle vehicle) {
        return this.vehicles.contains(vehicle);
    }
}
