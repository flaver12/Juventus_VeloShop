package org.fk.vs.data;

public abstract class AbstractVehicle implements Vehicle {
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
}
