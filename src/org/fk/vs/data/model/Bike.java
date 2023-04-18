package org.fk.vs.data.model;

import org.fk.vs.data.AbstractVehicle;
import org.fk.vs.data.enums.Status;
import org.fk.vs.data.enums.Type;
import org.fk.vs.data.interfaces.Vehicle;
import org.fk.vs.data.interfaces.VehicleDao;
import org.fk.vs.data.mock.VehicleDaoMock;

public class Bike extends AbstractVehicle{

	public Bike(int id, Status status, Type type, int price) {
	    super(id, status, type, price);
	}

	@Override
	public String print() {
	    return getId() + " is from type " + getType() + " and it costs " + getPrice() + " CHF.";
	}

	@Override
	public VehicleDao toDao() {
		VehicleDaoMock vehicleDaoMock = new VehicleDaoMock();
		vehicleDaoMock.setPrice(this.getPrice());
		vehicleDaoMock.setType(this.getType());
		vehicleDaoMock.setStatus(this.getStatus());
		vehicleDaoMock.setType(this.getType());

		return vehicleDaoMock;
	}
	
}
