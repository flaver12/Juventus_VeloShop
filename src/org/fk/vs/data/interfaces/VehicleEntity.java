package org.fk.vs.data.interfaces;


import org.fk.vs.data.enums.Status;
import org.fk.vs.data.enums.Type;

public interface VehicleEntity {
	public int getPrice();
	public void setPrice(int price);
    public int getId();
    public Type getType();
    public void setType(Type type);
    public Status getStatus();
    public void setStatus(Status status);
	public Vehicle toVehicle();
}
