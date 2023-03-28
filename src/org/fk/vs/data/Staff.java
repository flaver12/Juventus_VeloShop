package org.fk.vs.data;

public class Staff extends AbstractUser {

   private String shop;

   public Staff(int id, String name) {
        super(id, name);
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    @Override
    public String format() {
        return getName() + " is a staff member";
    } 
}
