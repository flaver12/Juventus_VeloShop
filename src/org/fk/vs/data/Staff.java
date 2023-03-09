package org.fk.vs.data;

public class Staff extends User{
   public Staff(int id, String name) {
        super(id, name);
    }

private String shop;

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    } 
}
