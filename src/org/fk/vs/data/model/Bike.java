package org.fk.vs.data.model;

import org.fk.vs.data.AbstractVehicle;
import org.fk.vs.data.enums.Status;
import org.fk.vs.data.enums.Type;
import org.fk.vs.data.interfaces.VehicleEntity;
import org.fk.vs.data.mock.VehicleEntityMock;

public class Bike extends AbstractVehicle{

	public Bike(int id, Status status, Type type, int price) {
	    super(id, status, type, price);
	}

	@Override
	public String print() {
	    return getId() + " is from type " + getType() + " and it costs " + getPrice() + " CHF.";
	}

	@Override
	public VehicleEntity toDao() {
		VehicleEntityMock vehicleDaoMock = new VehicleEntityMock();
		vehicleDaoMock.setPrice(this.getPrice());
		vehicleDaoMock.setType(this.getType());
		vehicleDaoMock.setStatus(this.getStatus());
		vehicleDaoMock.setType(this.getType());

		return vehicleDaoMock;
	}
	
}
