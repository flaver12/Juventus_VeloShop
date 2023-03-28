package org.fk.vs.data;

import org.fk.vs.data.interfaces.User;

public abstract class AbstractUser implements User {
   private String name;
    private String role;
    private int id;

    public AbstractUser(int id, String name) {
        this.name = name;
        this.id = id;
    }

    public abstract String format();

    public int getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
