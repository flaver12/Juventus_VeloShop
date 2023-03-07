package org.fk.vs.presentation;

import org.fk.vs.business.UserService;
import org.fk.vs.business.VehicleService;
import org.fk.vs.data.Customer;
import org.fk.vs.data.Staff;
import org.fk.vs.data.Status;
import org.fk.vs.data.Type;
import org.fk.vs.data.Vehicle;

public class Main {
   public static void main(String[] args) {
        System.out.println("It works");

        // Start up vehicle service
        VehicleService vehicleService = new VehicleService();
        vehicleService.AddVehicle(new Vehicle(Status.Open, Type.CityBike, 2000));
        vehicleService.AddVehicle(new Vehicle(Status.ReadyForPickUp, Type.MountainBike, 20056));

        // Start up user service
        UserService userService = new UserService();
        userService.AddUser(new Staff());
        userService.AddUser(new Customer());

        System.out.println("I have " + vehicleService.getVehicles().size() + " currently in the shop");
   }
}
