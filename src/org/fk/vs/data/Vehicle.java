package org.fk.vs.data;

public class Vehicle {
    private Status status;
    private Type type;
    private int price;

    public Vehicle(Status status, Type type, int price) {
        this.status = status;
        this.type = type;
        this.price = price;
    }

    public int getPrice() {
        return price;
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
