package org.fk.vs.presentation;

import java.util.List;
import java.util.Map.Entry;

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

public class Application {

   private VehicleService vehicleService;
   private UserService userService;
   private StorageService storageService;

    public Application() {
	this.vehicleService = new VehicleService();
	this.userService = new UserService();
	this.storageService = new StorageService(vehicleService, userService);
    }

    public void start() {
	// Register some vehicles in the vehicles services
	setupVehicleService();

	// Register some users in the users service
	setupUserService();

	// Print out some basic infos
	System.out.println("I have " + vehicleService.getVehicles().size() + " vehicle/s currently in the shop");
        System.out.println("I have " + userService.getAllCustomers().size() + " customer/s currently in the shop");
        System.out.println("I have " + userService.getAllStaff().size() + " staff currently in the shop");

	// Reserve a vehicle
	reserveVehicle();

	// Print out the current users
	printOutUsers();
    }

    private void setupVehicleService() {
	vehicleService.AddVehicle(new Bike(1, Status.Open, Type.CityBike, 2000));
        vehicleService.AddVehicle(new Bike(2, Status.ReadyForPickUp, Type.MountainBike, 20056));
    }

    private void setupUserService() {
	userService.AddUser(new Staff(1, "Hans Staff"));
        userService.AddUser(new Customer(2, "Karl Kunde"));
    }

    private void reserveVehicle() {
	System.out.println("==========");

        // Reserve a vehicle
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
    }

    private void printOutUsers() {
	// Display some users
        for (User user : userService.getAllUser()) {
	    System.out.println(user.format());
	}
    }
}
