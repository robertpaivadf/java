package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

public class Program {

	public static void main(String[] args) throws ParseException{
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
		
		//Dados iniciais, modelo, data de retirada e data de devolução
		System.out.println("Enter rental data");
		System.out.print("Car model: ");
		String model = sc.nextLine();
		System.out.print("Pickup (Retirada) (dd/MM/yyyy hh:ss): ");
		Date start = sdf.parse(sc.nextLine());
		System.out.print("Return (Devolução) (dd/MM/yyyy hh:ss): ");
		Date finish = sdf.parse(sc.nextLine());
		
		//inicia um aluguel de carro
		CarRental cr = new CarRental(start, finish, new Vehicle(model));
		
		System.out.print("Enter price per hour: ");
		double pricePerHour = sc.nextDouble();
		System.out.print("Enter price per day: ");
		double pricePerDay = sc.nextDouble();
		
		//chama o serviço de aluguel de carro
		RentalService rentalService = new RentalService(pricePerDay, pricePerHour, new BrazilTaxService());
		
		//processa a fatura
		rentalService.processInvoice(cr);
		
		System.out.println("Invoice (Fatura):");
		System.out.println("Basic payment (Bruto): " + String.format("%.2f", cr.getInvoice().getBasicPayment()));
		System.out.println("Tax (Taxa): " + String.format("%.2f", cr.getInvoice().getTax()));
		System.out.println("Total payment (Liquido): " + String.format("%.2f", cr.getInvoice().getTotalPayment()));
		
		sc.close();

	}

}
