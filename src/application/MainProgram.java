package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.CarRental;
import entities.Vehicle;
import services.BrazilTaxService;
import services.RentalService;

public class MainProgram {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		System.out.println("Enter rental data");
		System.out.print("Enter car model: ");
		String model = sc.nextLine();
		System.out.print("Pickup (dd/mm/yyyy hh:mm): ");
		Date start = sdf.parse(sc.nextLine());
		System.out.print("Return (dd/MM/yyyy hh:mm): ");
		Date finish = sdf.parse(sc.nextLine());
		
		CarRental car = new CarRental(start, finish, new Vehicle(model));	
		
		System.out.print("Enter price per hour: R$ ");
		double pricePerHour = sc.nextDouble();
		System.out.print("Enter price per day: R$ ");
		double pricePerDay = sc.nextDouble();
		
		RentalService rs = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());
		rs.processInvoice(car);
		
		System.out.println("--------------------------------");
		System.out.println("INVOICE");
		System.out.println("Basic payment: R$ " + String.format("%.2f", car.getInvoice().getBasicPayment()));
		System.out.println("Tax: R$ " + String.format("%.2f", car.getInvoice().getTax()));
		System.out.println("Total Payment: R$ "+ String.format("%.2f", car.getInvoice().totalPayment()));
		
		sc.close();
	}

}
