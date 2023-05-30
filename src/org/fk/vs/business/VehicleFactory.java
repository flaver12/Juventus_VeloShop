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
      if(instance != null) { // If we have an instance then just return the instance
	  return instance;
      }

      // Well we have not, so lets create one
      instance = new VehicleFactory();
      return instance;
   }

   public Vehicle createVehicle(Type type, int price) {
	idCounter = idCounter + 1;
	return new Bike(idCounter, Status.Open, type, price);
   }
}
