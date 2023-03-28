package org.fk.vs.data;

public interface User {
    public String format();
    public int getId();
    public String getRole();
    public void setRole(String role);
    public String getName();
    public void setName(String name);
}
