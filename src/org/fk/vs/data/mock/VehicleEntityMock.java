package org.fk.vs.data.mock;

import org.fk.vs.data.enums.Status;
import org.fk.vs.data.enums.Type;
import org.fk.vs.data.interfaces.Vehicle;
import org.fk.vs.data.interfaces.VehicleEntity;
import org.fk.vs.data.model.Bike;

public class VehicleEntityMock implements VehicleEntity {
	private Status status;
    private Type type;
    private int price;
    private int id;

	public VehicleEntityMock() {
		id = 1;
	}

    public int getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

	@Override
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public Vehicle toVehicle() {
		// Todo make this a little bit better
		// Map by type
		return new Bike(
			this.getId(),
			this.getStatus(),
			this.getType(),
			this.getPrice()
		);
	}
}
