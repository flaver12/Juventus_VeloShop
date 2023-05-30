package org.fk.vs.data;

import java.util.Objects;

import org.fk.vs.data.enums.Status;
import org.fk.vs.data.enums.Type;
import org.fk.vs.data.interfaces.Vehicle;

public abstract class AbstractVehicle implements Vehicle, Comparable<Vehicle> {
    private Status status;
    private Type type;
    private int price;
    private int id;

    public AbstractVehicle(int id, Status status, Type type, int price) {
        this.status = status;
        this.type = type;
        this.price = price;
        this.id = id;
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
	public int hashCode() {
		return Objects.hash(this.id, this.price, this.type);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;

		Vehicle vehicle = (Vehicle) o;

		return id == vehicle.getId() && price == vehicle.getPrice();
	}

	@Override
	public int compareTo(Vehicle vehicle) {
		return vehicle.getId() > this.getId() ? 1 : -1;
	}
}
