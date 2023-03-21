package org.fk.vs.data;

public interface Vehicle {
    public int getPrice();
    public int getId();
    public Type getType();
    public void setType(Type type);
    public Status getStatus();
    public void setStatus(Status status);
    public String print();
}
