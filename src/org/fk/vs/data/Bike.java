package org.fk.vs.data;

public class Bike extends AbstractVehicle{

	public Bike(int id, Status status, Type type, int price) {
	    super(id, status, type, price);
	}

	@Override
	public String print() {
	    return getId() + " is from type " + getType() + " and it costs " + getPrice() + " CHF.";
	}
	
}
