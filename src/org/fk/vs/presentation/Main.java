package org.fk.vs.presentation;

import java.util.List;

import org.fk.vs.business.StorageService;
import org.fk.vs.business.UserService;
import org.fk.vs.business.VehicleService;
import org.fk.vs.data.enums.Status;
import org.fk.vs.data.enums.Type;
import org.fk.vs.data.interfaces.User;
import org.fk.vs.data.interfaces.Vehicle;
import org.fk.vs.data.model.Bike;
import org.fk.vs.data.model.Customer;
import org.fk.vs.data.model.Staff;

import java.util.Map.Entry;

public class Main {
   public static void main(String[] args) {
        System.out.println("It works");

        // Start up vehicle service
        VehicleService vehicleService = new VehicleService();
        vehicleService.AddVehicle(new Bike(1, Status.Open, Type.CityBike, 2000));
        vehicleService.AddVehicle(new Bike(2, Status.ReadyForPickUp, Type.MountainBike, 20056));

        // Start up user service
        UserService userService = new UserService();
        userService.AddUser(new Staff(1, "Hans Staff"));
        userService.AddUser(new Customer(2, "Karl Kunde"));

        // Print some basic infos
        System.out.println("I have " + vehicleService.getVehicles().size() + " vehicle/s currently in the shop");
        System.out.println("I have " + userService.getAllCustomers().size() + " customer/s currently in the shop");
        System.out.println("I have " + userService.getAllStaff().size() + " staff currently in the shop");

        System.out.println("==========");
        // Reserve a vehicle
        StorageService storageService = new StorageService(vehicleService, userService);
        storageService.reserveVehicle(userService.findUserById(2), vehicleService.findVehicleById(1));
        List<Entry<Integer, Vehicle>> reservedVehicles = storageService.getReservedVehicles();

        // Print out all reserved vehicles
        System.out.println("I have this vehicles reserved");
        for (Entry<Integer, Vehicle> item : reservedVehicles) {
            System.out.println(item.getValue().print());
            User reservedBy = userService.findUserById(item.getKey()); // TODO can be improved, just use the user as a key
            System.out.println("Is reserved by:");
            System.out.println(reservedBy.format());
        }

        System.out.println("==========");
        // Display some users
        for (User user : userService.getAllUser()) {
            System.out.println(user.format());
        }
   }
}
