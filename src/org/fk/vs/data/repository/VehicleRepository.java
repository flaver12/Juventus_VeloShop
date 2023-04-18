package org.fk.vs.data.repository;

import java.util.ArrayList;
import java.util.Collection;

import org.fk.vs.data.interfaces.Vehicle;
import org.fk.vs.data.interfaces.VehicleEntity;


public class VehicleRepository {
	// Holds a list of all dao
	private Collection<VehicleEntity> vehicles = new ArrayList<VehicleEntity>();

	public void insertVehicle(VehicleEntity vehicle) {
		if (this.vehicles.contains(vehicle)) {
            return;
        }
		this.vehicles.add(vehicle);
	}

	public VehicleEntity findById(int id) {
		return vehicles.stream().filter(item -> item.getId() == id).toList().get(0); // TODO
	}

	public Collection<Vehicle> findAll() {
		Collection<Vehicle> result = new ArrayList<Vehicle>();
		for (VehicleEntity vehicle : this.vehicles) {
			result.add(vehicle.toVehicle());
		}

		return result;
	}

	
}
