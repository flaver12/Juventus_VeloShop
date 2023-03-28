package org.fk.vs.business;


import org.fk.vs.data.enums.Status;
import org.fk.vs.data.enums.Type;
import org.fk.vs.data.interfaces.Vehicle;
import org.fk.vs.data.model.Bike;

public class VehicleFactory {

   private static VehicleFactory instance;
   private int idCounter = 1;

   private VehicleFactory() {

   }

   public static VehicleFactory getInstance() {
      if(instance != null) {
	  return instance;
      }
      instance = new VehicleFactory();
      return instance;
   }

   public Vehicle createVehicle(Type type, int price) {
	return new Bike(idCounter ++, Status.Open, type, price);
   }
}
