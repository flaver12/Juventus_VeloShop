package org.fk.vs.presentation;

import org.fk.vs.business.StorageService;
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
        vehicleService.AddVehicle(new Vehicle(1, Status.Open, Type.CityBike, 2000));
        vehicleService.AddVehicle(new Vehicle(2, Status.ReadyForPickUp, Type.MountainBike, 20056));

        // Start up user service
        UserService userService = new UserService();
        userService.AddUser(new Staff(1, "Hans Staff"));
        userService.AddUser(new Customer(2, "Karl Kunde"));

        // Print some basic infos
        System.out.println("I have " + vehicleService.getVehicles().size() + " vehicle/s currently in the shop");
        System.out.println("I have " + userService.getAllCustomers().size() + " customer/s currently in the shop");
        System.out.println("I have " + userService.getAllStaff().size() + " staff currently in the shop");

        // Reserve a vehicle
        StorageService storageService = new StorageService(vehicleService, userService);
        storageService.reserveVehicle((Customer)userService.findUserById(2), null);
   }
}
